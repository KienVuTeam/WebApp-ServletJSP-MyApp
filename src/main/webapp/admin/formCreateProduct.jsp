<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags"%>
<template:adminTemplate title="create">
	<jsp:attribute name="content">
		<h1>Add new Product</h1>
    <hr>
    <div class="container">pageContext.request.contextPath
        <form action="${pageContext.request.contextPath}/admin/product?action=SaveOrUpdate&id=0" method="post">
            <div class="row">
                <div class="col-6">
                    <div class="form-group">
                        <label for="" class="form-label">Product name</label>
                        <input type="text" class="form-control" name="pName" placeholder="Enter product name">
                    </div>
                    <div class="form-group">
                        <label for="" class="form-group">Product describe</label>
                        <input type="text" class="form-control" name="pDescribe" placeholder="Enter describe">
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="" class="form-label">Price</label>
                        <input type="number" class="form-control" name="pPrice" placeholder="Enter price">
                    </div>
                    <div class="form-group">
                        <label for="" class="form-label">Status</label>
                        <select name="pStatus" id="" class="form-select">
                            <option value="" disabled>--choose options--</option>
                            <option value="true">Active</option>
                            <option value="false">Lock</option>
                        </select>
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="" class="form-label">Choose file</label>
                        <input type="file" class="form-control" name="pImage">
                    </div>
                </div>
            </div>
            
            <br>
            <div  style="display: flex; justify-content: center;">
                <input type="submit" class="btn btn-success" value="Create Product" style="width: 60%;">
            </div>
        </form>
    </div>
	</jsp:attribute>
</template:adminTemplate>