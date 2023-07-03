var todoList = [];

function addItem() {
  var newItem = document.getElementById("new-item").value;
  if (newItem !== "") {
    var task = {
      name: newItem,
      completed: false,
      timestamp: new Date()
    };
    todoList.push(task);
    document.getElementById("new-item").value = "";
    updateLists();
  }
}

function toggleItem(index) {
  todoList[index].completed = !todoList[index].completed;
  updateLists();
}

function deleteItem(index) {
  todoList.splice(index, 1);
  updateLists();
}

function updateLists() {
  var pendingItems = document.getElementById("pending-items");
  var completedItems = document.getElementById("completed-items");
  

  pendingItems.innerHTML = "";
  completedItems.innerHTML = "";
  
  for (var i = 0; i < todoList.length; i++) {
    var li = document.createElement("li");
    li.innerHTML = todoList[i].name;
    li.onclick = (function(index) {
      return function() {
        toggleItem(index);
      };
    })(i);
    
    if (todoList[i].completed) {
      li.classList.add("completed");
      completedItems.appendChild(li);
    } else {
      pendingItems.appendChild(li);
    }
    
    var deleteButton = document.createElement("button");
    deleteButton.innerHTML = "Delete";
    deleteButton.onclick = (function(index) {
      return function() {
        deleteItem(index);
      };
    })(i);
    li.appendChild(deleteButton);
  }
}
