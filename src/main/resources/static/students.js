const API="http://localhost:8080/students";

fetch(API)

.then(response=>response.json())

.then(data=>{

let table="";

data.forEach(student=>{

table+=`

<tr>

<td>${student.rollNo}</td>

<td>${student.name}</td>

<td>${student.department}</td>

</tr>

`;

});

document.getElementById("studentTable").innerHTML=table;

});