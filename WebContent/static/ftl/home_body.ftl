<#macro home_body>  
    <#compress> 
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">
					<h1>账户管理</h1>
				</div>
			</div>
			<div class="row-fluid" style="margin-top: 20px">
			    <div class="pull-right" style="margin-right: 500px">
			        <div class="btn-group">
			            <button type="button" class="btn btn-primary btn-sm" id="btn-add">
			                <i class="fa fa-plus"></i> 新增
			            </button>
			        </div>
			    </div>
			    <div class="row" style="margin-left: 5px">
			        <form id="queryForm" action="" method="post">
			            <div class="col-xs-2">
			                <input type="text" id="userCode" name="userCode" class="form-control input-sm" placeholder="编码">
			            </div>
			            <div class="col-xs-2">
			            	<input type="text" id="userName" name="userName" class="form-control input-sm" placeholder="名称">
			            </div>
			            <div class="col-xs-2">
			                <input type="text" id="createAt" name="createAt" class="datepicker form-control input-sm" placeholder="注册时间">
			            </div>
			            <div class="col-xs-2">
			                <select id="userType" name="userType" type="text" class="form-control select2">
			                	<option value="">请选择账号类型</option>
				                <option value="1">超级管理员</option>
				                <option value="2">管理员</option>
				                <option value="3">普通人员</option>
				            </select>
			            </div>
			            <button type="button" class="btn btn-primary btn-sm" id="btn-query">
			                <i class="fa fa-search"></i> 查询
			            </button>
			        </form>
			    </div>
			</div>
			<div class="panel-body">
				<table id="table_id_users" class="table table-striped table-hover">
				    <thead>
				        <tr>
				        	<th hidden>ID</th>
				        	<th hidden>版本</th>
				            <th>编码</th>
				            <th>名称</th>
				            <th>创建时间</th>
				            <th>最后登录时间</th>
				            <th>账号类型</th>
				            <th>状态</th>
				            <th>操作</th>
				        </tr>
				    </thead>
				    <tbody></tbody>
				</table>
			</div>
		</div>
	</#compress>  
</#macro> 