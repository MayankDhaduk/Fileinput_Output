<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File Upload</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	
	$(document).ready(function(){
		
		$.get('viewimg',{},function(rt){
			
			
			const data = JSON.parse(rt)
			
			var row = "";
			for(var i=0;i<data.length;i++)
			{
				row = row+"<tr><td>"+data[i].id+"</td><td>"+data[i].name+"</td><td><img src='img/"+data[i].img+"' alt='"+data[i].img+" height='50px' width='50px''></td></tr>"
			}
			$('#tdata').html(row)
			
		})
		
	})
	
	</script>
	
</head>
<body>
		<form action="upload" method="post" enctype="multipart/form-data">
		<span>${msg}</span>
		<label>Username</label>
		<input type="text" name="uname">
		<label>Profile Picture</label>
		<input type="file" name="file">
		<input type="submit">
		</form>
		
		<br><br>
		
		<table>
		<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Image</th>
		</tr>
		
		<tbody id="tdata">
		
		</tbody>
		</table>
		
</body>
</html>