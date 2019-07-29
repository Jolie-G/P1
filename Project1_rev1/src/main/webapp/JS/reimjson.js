//
//function myFunction() {
//  document.getElementById("clicking").click(myFunctionclicked); // Click on the checkbox
// 
//}
//
//
//function myFunctionclicked() {
//	console.log("INSIDE THE WINDOW ONLOAD");
//	console.log("inside onload function");
//	let xhttp = new XMLHttpRequest;
//	xhttp.onreadystatechange = function() {
//		if (xhttp.readyState == 4 && xhttp.status == 200) {
//			let info = JSON.parse(xhttp.responseText);
//			employeeTable = document.getElementById("tableinfo");

//			for (let i = 0; i < info.length; i++) {
//				let tr = document.createElement("tr");
//				let td1 = document.createElement("td");
//				let td2 = document.createElement("td");
//				let td3 = document.createElement("td");
//			    let td4 = document.createElement("td");
//				let td5 = document.createElement("td");
//	
//				td1.innerHTML = info[i].userId;
//				td2.innerHTML = info[i].firstname;
//				td3.innerHTML = info[i].lastname;
//				 td4.innerHTML = info[i].password;
//				td5.innerHTML = info[i].roleId;
//
//				tr.appendChild(td1);
//				tr.appendChild(td2);
//				tr.appendChild(td3);
//				 tr.appendChild(td4);
//				tr.appendChild(td5);

			//	employeeTable.appendChild(tr);
			
//		}
//	}    
			//console.log("ajax");
	//http://localhost:8080/PracticeServlets/html/GetAllReim.do
//    xhttp.open("get", 'http://localhost:8080/PracticeServlets/html/GetUserInfo.do');
	// xhttp.open("GET", 'http://localhost:9001/ProjectOne/reimbursementAll.obtain');
//}