癤?%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="dto.Product"%>
<%@ page import="dao.ProductRepository"%>
<%@ page errorPage="exceptionNoProductId.jsp"%>
<html>
<head>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<title>?곹뭹 ?곸꽭 ?뺣낫</title>
<script type="text/javascript">
	function addToCart() {
		if (confirm("?곹뭹???λ컮援щ땲??異붽??섏떆寃좎뒿?덇퉴?")) {
			document.addForm.submit();
		} else {		
			document.addForm.reset();
		}
	}
</script>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">?곹뭹 ?뺣낫</h1>
		</div>
	</div>
	<%
		String id = request.getParameter("id");
		ProductRepository dao = ProductRepository.getInstance();
		Product product = dao.getProductById(id);
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src="c:/upload/<%=product.getFilename()%>" style="width: 100%" />
			</div>
			<div class="col-md-6">
				<h3><%=product.getPname()%></h3>
				<p><%=product.getDescription()%>
				<p><b>?곹뭹 肄붾뱶 : </b><span class="badge badge-danger"> <%=product.getProductId()%></span>
				<p><b>?쒖“??/b> : <%=product.getManufacturer()%>
				<p><b>遺꾨쪟</b> : <%=product.getCategory()%>
				<p><b>?ш퀬 ??/b> : <%=product.getUnitsInStock()%>
				<h4><%=product.getUnitPrice()%>??/h4>
				<p><form name="addForm" action="./addCart.jsp?id=<%=product.getProductId()%>" method="post">
					<a href="#" class="btn btn-info" onclick="addToCart()"> ?곹뭹 二쇰Ц &raquo;</a>
					<a href="./cart.jsp" class="btn btn-warning"> ?λ컮援щ땲 &raquo;</a> 
					<a href="./products.jsp" class="btn btn-secondary"> ?곹뭹 紐⑸줉 &raquo;</a>
				</form>
			</div>
		</div>
		<hr>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>
