<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','student_no') || $check_field('add','student_no') || $check_field('set','student_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生编号" prop="student_no">
													<el-select v-if="user_group === '管理员' || (form['apply_for_a_change_of_bed_id'] && $check_field('set','student_no')) || (!form['apply_for_a_change_of_bed_id'] && $check_field('add','student_no'))" id="student_no" v-model="form['student_no']" :disabled="disabledObj['student_no_isDisabled']">
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
							  v-if="user_group === '管理员' || (form['apply_for_a_change_of_bed_id'] && $check_field('set','student_name')) || (!form['apply_for_a_change_of_bed_id'] && $check_field('add','student_name'))" :disabled="disabledObj['student_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_name')">{{form['student_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','class_name') || $check_field('add','class_name') || $check_field('set','class_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="班级名称" prop="class_name">
												<el-input id="class_name" v-model="form['class_name']" placeholder="请输入班级名称"
							  v-if="user_group === '管理员' || (form['apply_for_a_change_of_bed_id'] && $check_field('set','class_name')) || (!form['apply_for_a_change_of_bed_id'] && $check_field('add','class_name'))" :disabled="disabledObj['class_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','class_name')">{{form['class_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','name_of_dormitory') || $check_field('add','name_of_dormitory') || $check_field('set','name_of_dormitory')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="寝室名称" prop="name_of_dormitory">
												<el-input id="name_of_dormitory" v-model="form['name_of_dormitory']" placeholder="请输入寝室名称"
							  v-if="user_group === '管理员' || (form['apply_for_a_change_of_bed_id'] && $check_field('set','name_of_dormitory')) || (!form['apply_for_a_change_of_bed_id'] && $check_field('add','name_of_dormitory'))" :disabled="disabledObj['name_of_dormitory_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_dormitory')">{{form['name_of_dormitory']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','located_in_the_building') || $check_field('add','located_in_the_building') || $check_field('set','located_in_the_building')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="所在楼宇" prop="located_in_the_building">
												<el-input id="located_in_the_building" v-model="form['located_in_the_building']" placeholder="请输入所在楼宇"
							  v-if="user_group === '管理员' || (form['apply_for_a_change_of_bed_id'] && $check_field('set','located_in_the_building')) || (!form['apply_for_a_change_of_bed_id'] && $check_field('add','located_in_the_building'))" :disabled="disabledObj['located_in_the_building_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','located_in_the_building')">{{form['located_in_the_building']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','housing_management_number') || $check_field('add','housing_management_number') || $check_field('set','housing_management_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="宿管编号" prop="housing_management_number">
													<el-select v-if="user_group === '管理员' || (form['apply_for_a_change_of_bed_id'] && $check_field('set','housing_management_number')) || (!form['apply_for_a_change_of_bed_id'] && $check_field('add','housing_management_number'))" id="housing_management_number" v-model="form['housing_management_number']" :disabled="disabledObj['housing_management_number_isDisabled']">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','application_time') || $check_field('add','application_time') || $check_field('set','application_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="申请时间" prop="application_time">
								<el-date-picker :disabled="disabledObj['application_time_isDisabled']" v-if="user_group === '管理员' || (form['apply_for_a_change_of_bed_id'] && $check_field('set','application_time')) || (!form['apply_for_a_change_of_bed_id'] && $check_field('add','application_time'))" id="application_time"
						v-model="form['application_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','application_time')">{{form['application_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reason_for_application') || $check_field('add','reason_for_application') || $check_field('set','reason_for_application')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="申请原因" prop="reason_for_application">
												<el-input id="reason_for_application" v-model="form['reason_for_application']" placeholder="请输入申请原因"
							  v-if="user_group === '管理员' || (form['apply_for_a_change_of_bed_id'] && $check_field('set','reason_for_application')) || (!form['apply_for_a_change_of_bed_id'] && $check_field('add','reason_for_application'))" :disabled="disabledObj['reason_for_application_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','reason_for_application')">{{form['reason_for_application']}}</div>
											</el-form-item>
			</el-col>
							<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核状态" prop="examine_state">
					<el-select id="examine_state" v-model="form['examine_state']"
						v-if="user_group === '管理员' || (form['examine_state'] && $check_examine()) || (!form['examine_state'] && $check_examine())">
						<el-option key="未审核" label="未审核" value="未审核"></el-option>
						<el-option key="已通过" label="已通过" value="已通过"></el-option>
						<el-option key="未通过" label="未通过" value="未通过"></el-option>
					</el-select>
					<div v-else>{{form["examine_state"]}}</div>
				</el-form-item>
			</el-col>
					<el-col :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="审核回复" prop="examine_reply">
					<el-input id="examine_reply" v-model="form['examine_reply']" placeholder="请输入审核回复"
						v-if="user_group === '管理员' || (form['examine_reply'] && $check_examine()) || (!form['examine_reply'] && $check_examine())"></el-input>
					<div v-else>{{form["examine_reply"]}}</div>
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
				field: "apply_for_a_change_of_bed_id",
				url_add: "~/api/apply_for_a_change_of_bed/add?",
				url_set: "~/api/apply_for_a_change_of_bed/set?",
				url_get_obj: "~/api/apply_for_a_change_of_bed/get_obj?",
				url_upload: "~/api/apply_for_a_change_of_bed/upload?",

				query: {
					"apply_for_a_change_of_bed_id": 0,
				},

				form: {
								"student_no": 0, // 学生编号
										"student_name":  '', // 学生姓名
										"class_name":  '', // 班级名称
										"name_of_dormitory":  '', // 寝室名称
										"located_in_the_building":  '', // 所在楼宇
										"housing_management_number": 0, // 宿管编号
										"application_time":  '', // 申请时间
										"reason_for_application":  '', // 申请原因
									"examine_state": "未审核",
							"examine_reply": "",
							"apply_for_a_change_of_bed_id": 0, // ID
						
				},
				disabledObj:{
								"student_no_isDisabled": false,
										"student_name_isDisabled": false,
										"class_name_isDisabled": false,
										"name_of_dormitory_isDisabled": false,
										"located_in_the_building_isDisabled": false,
										"housing_management_number_isDisabled": false,
										"application_time_isDisabled": false,
										"reason_for_application_isDisabled": false,
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
														        if (this.form["application_time"].indexOf("-")===-1){
          this.form["application_time"] = this.$toTime(parseInt(this.form["application_time"]),"yyyy-MM-dd")
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


																				        if(this.form["application_time"]=="0000-00-00"){
          this.form["application_time"] = null;
        }
				if(parseInt(this.form["application_time"]) > 9999){
					this.form["application_time"] = this.$toTime(parseInt(this.form["application_time"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/apply_for_a_change_of_bed/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/apply_for_a_change_of_bed/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/apply_for_a_change_of_bed/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/apply_for_a_change_of_bed/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/apply_for_a_change_of_bed/view','get');
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
