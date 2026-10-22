const API = "http://localhost:8080/students/count";

fetch(API)
.then(res=>res.text())
.then(count=>{

document.getElementById("totalStudents").innerHTML=count;

});