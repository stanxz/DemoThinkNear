
function openStudentModal(id,firstname,lastname){

		$("#postResultEstudianteDiv").modal();
		$("#myModalDialog").text("");
    	$.ajax({
			type : "GET",
			contentType : "application/json",
			url : 'http://localhost:8080/classes/showclassesbystudent?idStudent=' + id + '&firstname=' + firstname + '&lastname=' + lastname,

			success : function(result) {
				$("#myModalDialog").html(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
 
    };
    
    
    function openClassModal(cod,title){

		$("#postResultClaseDiv").modal();
		$("#myModalDialog").text("");
    	$.ajax({
			type : "GET",
			contentType : "application/json",
			url : 'http://localhost:8080/students/showstudentsbyclass?codClase=' + cod + '&title=' + title,

			success : function(result) {
				$("#myModalDialog").html(result);
					
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
 
    };
    
    function searchStudent(){
    	
    	var palabra=$("#txtSearchSt").val();

		$("#myStudentsDiv").text("");
		
    	$.ajax({
			type : "GET",
			contentType : "application/json",
			url : 'http://localhost:8080/students/showstudentsbykeyword?keyword=' + palabra,
			success : function(valor) {
				
				$("#myStudentsDiv").html(valor);
					
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    };

    function searchClass(){

    	var palabra=$("#txtSearchCl").val();
    	
		$("#myClassesDiv").text("");
		
    	$.ajax({
			type : "GET",
			contentType : "application/json",
			url : 'http://localhost:8080/classes/showclassesbykeyword?keyword=' + palabra,
			success : function(resultado) {
				
				$("#myClassesDiv").html(resultado);
					
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    };