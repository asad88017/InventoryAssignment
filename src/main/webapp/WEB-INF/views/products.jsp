<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
</head>
<body onload="load();">

		<input type="hidden" id="product_id">
		Product Name: <input type="text" id="name" required="required" name="product_name"><br>
		Product Quantity: <input type="text" id="quantity" required="required" name="product_quantity"><br>
		Product Price: <input type="text" id="price" required="required" name="product_price"><br>
		<button onclick="submit();">Submit</button>
	
	

		<table id="table" border=1>
			<tr> <th>Product Name </th> <th>Product Quantity </th> <th> Product Price </th> <th> Edit </th> <th> Delete </th> </tr>
		
		</table>
			
	
	<script type="text/javascript">
	data = "";
	submit = function(){
		 
			$.ajax({
				url:'saveOrUpdateProduct',
				type:'POST',
				data:{product_name:$('#name').val(),product_quantity:$('#quantity').val(),product_price:$('#price')},
				success: function(response){
						alert(response.message);
						load();		
				}				
			});			
	}
	
	delete_ = function(id){		 
		 $.ajax({
			url:'delete',
			type:'POST',
			data:{user_id:id},
			success: function(response){
					alert(response.message);
					load();
			}				
		});
}
	

	edit = function (index){
		$("#user_id").val(data[index].user_id);
		$("#name").val(data[index].user_name);
		$("#email").val(data[index].email);
		
	}
	
	
	load = function(){	
		$.ajax({
			url:'list',
			type:'POST',
			success: function(response){
					data = response.data;
					$('.tr').remove();
					for(i=0; i<response.data.length; i++){					
						$("#table").append("<tr class='tr'> <td> "+response.data[i].user_name+" </td> <td> "+response.data[i].email+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].user_id+");'> Delete </a>  </td> </tr>");
					}			
			}				
		});
		
	}
		
	</script>
	
</body>
</html>