<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','student_no') || $check_field('add','student_no') || $check_field('set','student_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生编号" prop="student_no">
													<el-select v-if="user_group === '管理员' || (form['leave_reporting_id'] && $check_field('set','student_no')) || (!form['leave_reporting_id'] && $check_field('add','student_no'))" id="student_no" v-model="form['student_no']" :disabled="disabledObj['student_no_isDisabled']">
							<el-option v-for="o in list_user_student_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','student_no')" id="student_no" v-model="form['student_no']" :disabled="true">
							<el-option v-for="o in list_user_student_no" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','student_name') || $check_field('add','student_name') || $check_field('set','student_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生姓名" prop="student_name">
												<el-input id="student_name" v-model="form['student_name']" placeholder="请输入学生姓名"
							  v-if="user_group === '管理员' || (form['leave_reporting_id'] && $check_field('set','student_name')) || (!form['leave_reporting_id'] && $check_field('add','student_name'))" :disabled="disabledObj['student_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_name')">{{form['student_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','class_name') || $check_field('add','class_name') || $check_field('set','class_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="班级名称" prop="class_name">
												<el-input id="class_name" v-model="form['class_name']" placeholder="请输入班级名称"
							  v-if="user_group === '管理员' || (form['leave_reporting_id'] && $check_field('set','class_name')) || (!form['leave_reporting_id'] && $check_field('add','class_name'))" :disabled="disabledObj['class_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','class_name')">{{form['class_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','name_of_dormitory') || $check_field('add','name_of_dormitory') || $check_field('set','name_of_dormitory')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="寝室名称" prop="name_of_dormitory">
												<el-input id="name_of_dormitory" v-model="form['name_of_dormitory']" placeholder="请输入寝室名称"
							  v-if="user_group === '管理员' || (form['leave_reporting_id'] && $check_field('set','name_of_dormitory')) || (!form['leave_reporting_id'] && $check_field('add','name_of_dormitory'))" :disabled="disabledObj['name_of_dormitory_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_dormitory')">{{form['name_of_dormitory']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','located_in_the_building') || $check_field('add','located_in_the_building') || $check_field('set','located_in_the_building')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="所在楼宇" prop="located_in_the_building">
												<el-input id="located_in_the_building" v-model="form['located_in_the_building']" placeholder="请输入所在楼宇"
							  v-if="user_group === '管理员' || (form['leave_reporting_id'] && $check_field('set','located_in_the_building')) || (!form['leave_reporting_id'] && $check_field('add','located_in_the_building'))" :disabled="disabledObj['located_in_the_building_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','located_in_the_building')">{{form['located_in_the_building']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','housing_management_number') || $check_field('add','housing_management_number') || $check_field('set','housing_management_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="宿管编号" prop="housing_management_number">
													<el-select v-if="user_group === '管理员' || (form['leave_reporting_id'] && $check_field('set','housing_management_number')) || (!form['leave_reporting_id'] && $check_field('add','housing_management_number'))" id="housing_management_number" v-model="form['housing_management_number']" :disabled="disabledObj['housing_management_number_isDisabled']">
							<el-option v-for="o in list_user_housing_management_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','housing_management_number')" id="housing_management_number" v-model="form['housing_management_number']" :disabled="true">
							<el-option v-for="o in list_user_housing_management_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reporting_time') || $check_field('add','reporting_time') || $check_field('set','reporting_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="报备时间" prop="reporting_time">
								<el-date-picker :disabled="disabledObj['reporting_time_isDisabled']" v-if="user_group === '管理员' || (form['leave_reporting_id'] && $check_field('set','reporting_time')) || (!form['leave_reporting_id'] && $check_field('add','reporting_time'))" id="reporting_time"
						v-model="form['reporting_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','reporting_time')">{{form['reporting_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reason_for_taking_leave') || $check_field('add','reason_for_taking_leave') || $check_field('set','reason_for_taking_leave')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="请假原因" prop="reason_for_taking_leave">
												<el-input id="reason_for_taking_leave" v-model="form['reason_for_taking_leave']" placeholder="请输入请假原因"
							  v-if="user_group === '管理员' || (form['leave_reporting_id'] && $check_field('set','reason_for_taking_leave')) || (!form['leave_reporting_id'] && $check_field('add','reason_for_taking_leave'))" :disabled="disabledObj['reason_for_taking_leave_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','reason_for_taking_leave')">{{form['reason_for_taking_leave']}}</div>
											</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "leave_reporting_id",
				url_add: "~/api/leave_reporting/add?",
				url_set: "~/api/leave_reporting/set?",
				url_get_obj: "~/api/leave_reporting/get_obj?",
				url_upload: "~/api/leave_reporting/upload?",

				query: {
					"leave_reporting_id": 0,
				},

				form: {
								"student_no": 0, // 学生编号
										"student_name":  '', // 学生姓名
										"class_name":  '', // 班级名称
										"name_of_dormitory":  '', // 寝室名称
										"located_in_the_building":  '', // 所在楼宇
										"housing_management_number": 0, // 宿管编号
										"reporting_time":  '', // 报备时间
										"reason_for_taking_leave":  '', // 请假原因
											"leave_reporting_id": 0, // ID
						
				},
				disabledObj:{
								"student_no_isDisabled": false,
										"student_name_isDisabled": false,
										"class_name_isDisabled": false,
										"name_of_dormitory_isDisabled": false,
										"located_in_the_building_isDisabled": false,
										"housing_management_number_isDisabled": false,
										"reporting_time_isDisabled": false,
										"reason_for_taking_leave_isDisabled": false,
										},

	
					// 用户列表
				list_user_student_no: [],
				
		
		
		
		
					// 用户列表
				list_user_housing_management_number: [],
				
		
	
			}
		},
		methods: {


	
	
				/**
			 * 获取学生用户列表
			 */
			async get_list_user_student_no() {
                // if(this.user_group !== "管理员" && this.form["student_no"] === 0) {
                //     this.form["student_no"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=学生");
                if(json.result && json.result.list){
                    this.list_user_student_no = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_student_no(id){
				var obj = this.list_user_student_no.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
			
	
			
	
			
	
				/**
			 * 获取宿管员用户列表
			 */
			async get_list_user_housing_management_number() {
                // if(this.user_group !== "管理员" && this.form["housing_management_number"] === 0) {
                //     this.form["housing_management_number"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=宿管员");
                if(json.result && json.result.list){
                    this.list_user_housing_management_number = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_housing_management_number(id){
				var obj = this.list_user_housing_management_number.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
															// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
																													
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
														        if (this.form["reporting_time"].indexOf("-")===-1){
          this.form["reporting_time"] = this.$toTime(parseInt(this.form["reporting_time"]),"yyyy-MM-dd")
        }
							$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																				        if(this.form["reporting_time"]=="0000-00-00"){
          this.form["reporting_time"] = null;
        }
				if(parseInt(this.form["reporting_time"]) > 9999){
					this.form["reporting_time"] = this.$toTime(parseInt(this.form["reporting_time"]),"yyyy-MM-dd")
				}
					


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																														return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/leave_reporting/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/leave_reporting/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/leave_reporting/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/leave_reporting/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/leave_reporting/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
					this.get_list_user_student_no();
																this.get_list_user_housing_management_number();
									},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
