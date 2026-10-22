const BASE_URL="http://localhost:8080";

function searchStudent(){

const roll=document.getElementById("rollNo").value;

fetch(BASE_URL+"/students/"+roll)

.then(res=>res.json())

.then(student=>{

document.getElementById("name").value=student.name;

});

}

function saveMarks(){

const marks={

rollNo:document.getElementById("rollNo").value,

tamil:document.getElementById("tamil").value,

english:document.getElementById("english").value,

maths:document.getElementById("maths").value,

science:document.getElementById("science").value,

social:document.getElementById("social").value

};

fetch(BASE_URL+"/marks",{

method:"POST",

headers:{

"Content-Type":"application/json"

},

body:JSON.stringify(marks)

})

.then(()=>{

alert("Marks Saved");

loadMarks();

});

}

function loadMarks(){

fetch(BASE_URL+"/marks")

.then(res=>res.json())

.then(data=>{

let rows="";

data.forEach(student=>{

rows+=`

<tr>

<td>${student.rollNo}</td>

<td>${student.name}</td>

<td>${student.tamil}</td>

<td>${student.english}</td>

<td>${student.maths}</td>

<td>${student.science}</td>

<td>${student.social}</td>

<td>${student.grade}</td>

</tr>

`;

});

document.getElementById("marksTable").innerHTML=rows;

});

}

loadMarks();