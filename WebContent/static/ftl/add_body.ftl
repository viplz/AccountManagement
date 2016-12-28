<#macro add_body>  
    <#compress>
    	<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title">
					<h1>账户注册</h1>
				</div>
			</div>
			<div class="panel-body">
				<form id="addForm" class="form-horizontal" action="" role="form">
				  <div class="form-group">
				    <label for="name" class="col-xs-2 control-label">编码：</label>
				    <div class="col-xs-3">
				    	<input type="text" class="form-control" id="userCode" name="userCode" placeholder="请输入编码">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="name" class="col-xs-2 control-label">名称：</label>
				    <div class="col-xs-3">
				    	<input type="text" class="form-control" id="userName" name="userName" placeholder="请输入名称">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="name" class="col-xs-2 control-label">密码：</label>
				    <div class="col-xs-3">
				    	<input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="name" class="col-xs-2 control-label">状态：</label>
				    <div class="col-xs-3 btn-group" id="state" data-toggle="buttons">
				       <label class="btn btn-default active">
				         <input type="radio" class="toggle" name="state" value="0">封存
				       </label>
				       <label class="btn btn-default">
				         <input type="radio" class="toggle" name="state" value="1">启封
				       </label>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="name" class="col-xs-2 control-label">账号类型：</label>
				    <div class="col-xs-3">
				    	<select id="userType" name="userType" type="text" class="form-control select2">
				    		<option value="3">普通人员</option>
				    		<option value="2">管理员</option>
			                <option value="1">超级管理员</option>
			            </select>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="name" class="col-xs-2 control-label">备注：</label>
				    <div class="col-xs-3">
				    	<textarea class="form-control" rows="3" name="remark" id="remark"></textarea>
			    	</div>
			      </div>
				  <div class="form-group">
	    			<div class="col-sm-offset-2 col-xs-2">
				  		<button id="form_submit" type="button" class="btn btn-default">提交</button>
			  		</div>
		  		  </div>
				</form>
			</div>
		</div>
    </#compress>
</#macro>