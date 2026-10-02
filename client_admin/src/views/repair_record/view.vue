<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','student_no') || $check_field('add','student_no') || $check_field('set','student_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学生编号" prop="student_no">
													<el-select v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','student_no')) || (!form['repair_record_id'] && $check_field('add','student_no'))" id="student_no" v-model="form['student_no']" :disabled="disabledObj['student_no_isDisabled']">
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
							  v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','student_name')) || (!form['repair_record_id'] && $check_field('add','student_name'))" :disabled="disabledObj['student_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','student_name')">{{form['student_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','class_name') || $check_field('add','class_name') || $check_field('set','class_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="班级名称" prop="class_name">
												<el-input id="class_name" v-model="form['class_name']" placeholder="请输入班级名称"
							  v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','class_name')) || (!form['repair_record_id'] && $check_field('add','class_name'))" :disabled="disabledObj['class_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','class_name')">{{form['class_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','name_of_dormitory') || $check_field('add','name_of_dormitory') || $check_field('set','name_of_dormitory')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="寝室名称" prop="name_of_dormitory">
												<el-input id="name_of_dormitory" v-model="form['name_of_dormitory']" placeholder="请输入寝室名称"
							  v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','name_of_dormitory')) || (!form['repair_record_id'] && $check_field('add','name_of_dormitory'))" :disabled="disabledObj['name_of_dormitory_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_dormitory')">{{form['name_of_dormitory']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','located_in_the_building') || $check_field('add','located_in_the_building') || $check_field('set','located_in_the_building')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="所在楼宇" prop="located_in_the_building">
												<el-input id="located_in_the_building" v-model="form['located_in_the_building']" placeholder="请输入所在楼宇"
							  v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','located_in_the_building')) || (!form['repair_record_id'] && $check_field('add','located_in_the_building'))" :disabled="disabledObj['located_in_the_building_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','located_in_the_building')">{{form['located_in_the_building']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','housing_management_number') || $check_field('add','housing_management_number') || $check_field('set','housing_management_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="宿管编号" prop="housing_management_number">
													<el-select v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','housing_management_number')) || (!form['repair_record_id'] && $check_field('add','housing_management_number'))" id="housing_management_number" v-model="form['housing_management_number']" :disabled="disabledObj['housing_management_number_isDisabled']">
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
								<el-col v-if="user_group === '管理员' || $check_field('get','fault_description') || $check_field('add','fault_description') || $check_field('set','fault_description')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="故障描述" prop="fault_description">
								<el-input type="textarea" id="fault_description" v-model="form['fault_description']" placeholder="请输入故障描述"
						v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','fault_description')) || (!form['repair_record_id'] && $check_field('add','fault_description'))" :disabled="disabledObj['fault_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','fault_description')">{{form['fault_description']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','maintenance_personnel_number') || $check_field('add','maintenance_personnel_number') || $check_field('set','maintenance_personnel_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="维修员编号" prop="maintenance_personnel_number">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_maintenance_personnel_number(form['maintenance_personnel_number']) }}
							<!--<el-input id="business_name" v-model="form['maintenance_personnel_number']" placeholder="请输入维修员编号"-->
							<!--v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','maintenance_personnel_number')) || (!form['repair_record_id'] && $check_field('add','maintenance_personnel_number'))" :disabled="disabledObj['maintenance_personnel_number_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','maintenance_personnel_number')">{{form['maintenance_personnel_number']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','maintenance_personnel_number')) || (!form['repair_record_id'] && $check_field('add','maintenance_personnel_number'))" id="maintenance_personnel_number" v-model="form['maintenance_personnel_number']" :disabled="disabledObj['maintenance_personnel_number_isDisabled']">
								<el-option v-for="o in list_user_maintenance_personnel_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','maintenance_personnel_number')" id="maintenance_personnel_number" v-model="form['maintenance_personnel_number']" :disabled="true">
								<el-option v-for="o in list_user_maintenance_personnel_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="maintenance_personnel_number" v-model="form['maintenance_personnel_number']" :disabled="disabledObj['maintenance_personnel_number_isDisabled']">
							<el-option v-for="o in list_user_maintenance_personnel_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','name_of_maintenance_personnel') || $check_field('add','name_of_maintenance_personnel') || $check_field('set','name_of_maintenance_personnel')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="维修员姓名" prop="name_of_maintenance_personnel">
												<el-input id="name_of_maintenance_personnel" v-model="form['name_of_maintenance_personnel']" placeholder="请输入维修员姓名"
							  v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','name_of_maintenance_personnel')) || (!form['repair_record_id'] && $check_field('add','name_of_maintenance_personnel'))" :disabled="disabledObj['name_of_maintenance_personnel_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_maintenance_personnel')">{{form['name_of_maintenance_personnel']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','repair_time') || $check_field('add','repair_time') || $check_field('set','repair_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="维修时间" prop="repair_time">
								<el-date-picker :disabled="disabledObj['repair_time_isDisabled']" v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','repair_time')) || (!form['repair_record_id'] && $check_field('add','repair_time'))" id="repair_time"
						v-model="form['repair_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','repair_time')">{{form['repair_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','maintenance_status') || $check_field('add','maintenance_status') || $check_field('set','maintenance_status')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="维修情况" prop="maintenance_status">
								<el-select id="maintenance_status" v-model="form['maintenance_status']"
						v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','maintenance_status')) || (!form['repair_record_id'] && $check_field('add','maintenance_status'))">
						<el-option v-for="o in list_maintenance_status" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','maintenance_status')">{{form['maintenance_status']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','annotation_notes') || $check_field('add','annotation_notes') || $check_field('set','annotation_notes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="标注说明" prop="annotation_notes">
												<el-input id="annotation_notes" v-model="form['annotation_notes']" placeholder="请输入标注说明"
							  v-if="user_group === '管理员' || (form['repair_record_id'] && $check_field('set','annotation_notes')) || (!form['repair_record_id'] && $check_field('add','annotation_notes'))" :disabled="disabledObj['annotation_notes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','annotation_notes')">{{form['annotation_notes']}}</div>
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
				field: "repair_record_id",
				url_add: "~/api/repair_record/add?",
				url_set: "~/api/repair_record/set?",
				url_get_obj: "~/api/repair_record/get_obj?",
				url_upload: "~/api/repair_record/upload?",

				query: {
					"repair_record_id": 0,
				},

				form: {
								"student_no": 0, // 学生编号
										"student_name":  '', // 学生姓名
										"class_name":  '', // 班级名称
										"name_of_dormitory":  '', // 寝室名称
										"located_in_the_building":  '', // 所在楼宇
										"housing_management_number": 0, // 宿管编号
										"fault_description":  '', // 故障描述
										"maintenance_personnel_number": 0, // 维修员编号
										"name_of_maintenance_personnel":  '', // 维修员姓名
										"repair_time":  '', // 维修时间
										"maintenance_status":  '', // 维修情况
										"annotation_notes":  '', // 标注说明
											"repair_record_id": 0, // ID
						
				},
				disabledObj:{
								"student_no_isDisabled": false,
										"student_name_isDisabled": false,
										"class_name_isDisabled": false,
										"name_of_dormitory_isDisabled": false,
										"located_in_the_building_isDisabled": false,
										"housing_management_number_isDisabled": false,
										"fault_description_isDisabled": false,
										"maintenance_personnel_number_isDisabled": false,
										"name_of_maintenance_personnel_isDisabled": false,
										"repair_time_isDisabled": false,
										"maintenance_status_isDisabled": false,
										"annotation_notes_isDisabled": false,
										},

	
					// 用户列表
				list_user_student_no: [],
				
		
		
		
		
					// 用户列表
				list_user_housing_management_number: [],
				
		
					// 用户列表
				list_user_maintenance_personnel_number: [],
						// 用户组
				group_user_maintenance_personnel_number: "",
				
		
						// 维修情况选项列表
				list_maintenance_status: ['已修复','未修复'],
	
		
	
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
			 * 获取维修员用户列表
			 */
			async get_list_user_maintenance_personnel_number() {
                // if(this.user_group !== "管理员" && this.form["maintenance_personnel_number"] === 0) {
                //     this.form["maintenance_personnel_number"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=维修员");
                if(json.result && json.result.list){
                    this.list_user_maintenance_personnel_number = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取维修员用户组
			 */
			async get_group_user_maintenance_personnel_number() {
							this.form["maintenance_personnel_number"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=维修员");
				if(json.result && json.result.obj){
					this.group_user_maintenance_personnel_number = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_maintenance_personnel_number(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_maintenance_personnel_number.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
									for (let key in _this.form) {
							arrForm.push(key)
						}
												_this.form["maintenance_personnel_number"] = id
									_this.disabledObj['maintenance_personnel_number' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "maintenance_personnel_number") {
			                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
			                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								  break;
								} else {
								  _this.disabledObj[arrForm[j] + '_isDisabled'] = true
								}
							  }
							}
						  }
						}
					}
				});
			},
					get_user_maintenance_personnel_number(id){
				var obj = this.list_user_maintenance_personnel_number.getObj({"user_id":id});
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
																				        if (this.form["repair_time"].indexOf("-")===-1){
          this.form["repair_time"] = this.$toTime(parseInt(this.form["repair_time"]),"yyyy-MM-dd")
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


																													        if(this.form["repair_time"]=="0000-00-00"){
          this.form["repair_time"] = null;
        }
				if(parseInt(this.form["repair_time"]) > 9999){
					this.form["repair_time"] = this.$toTime(parseInt(this.form["repair_time"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/repair_record/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/repair_record/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/repair_record/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/repair_record/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/repair_record/view','get');
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
										this.get_list_user_maintenance_personnel_number();
					this.get_group_user_maintenance_personnel_number();
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
