<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','dormitory_name') || $check_field('add','dormitory_name') || $check_field('set','dormitory_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="宿舍名称" prop="dormitory_name">
												<el-input id="dormitory_name" v-model="form['dormitory_name']" placeholder="请输入宿舍名称"
							  v-if="user_group === '管理员' || (form['dormitory_management_id'] && $check_field('set','dormitory_name')) || (!form['dormitory_management_id'] && $check_field('add','dormitory_name'))" :disabled="disabledObj['dormitory_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','dormitory_name')">{{form['dormitory_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','dormitory_type') || $check_field('add','dormitory_type') || $check_field('set','dormitory_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="宿舍类型" prop="dormitory_type">
												<el-input id="dormitory_type" v-model="form['dormitory_type']" placeholder="请输入宿舍类型"
							  v-if="user_group === '管理员' || (form['dormitory_management_id'] && $check_field('set','dormitory_type')) || (!form['dormitory_management_id'] && $check_field('add','dormitory_type'))" :disabled="disabledObj['dormitory_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','dormitory_type')">{{form['dormitory_type']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_beds') || $check_field('add','number_of_beds') || $check_field('set','number_of_beds')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="床位数量" prop="number_of_beds">
								<el-input-number id="number_of_beds" v-model.number="form['number_of_beds']"
						v-if="user_group === '管理员' || (form['dormitory_management_id'] && $check_field('set','number_of_beds')) || (!form['dormitory_management_id'] && $check_field('add','number_of_beds'))" :disabled="disabledObj['number_of_beds_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_beds')">{{form['number_of_beds']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','located_in_the_building') || $check_field('add','located_in_the_building') || $check_field('set','located_in_the_building')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="所在楼宇" prop="located_in_the_building">
								<el-select id="located_in_the_building" v-model="form['located_in_the_building']"
						v-if="user_group === '管理员' || (form['dormitory_management_id'] && $check_field('set','located_in_the_building')) || (!form['dormitory_management_id'] && $check_field('add','located_in_the_building'))">
						<el-option v-for="o in list_located_in_the_building" :key="o['building_name']" :label="o['building_name']"
							:value="o['building_name']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','located_in_the_building')">{{form['located_in_the_building']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','supporting_equipment') || $check_field('add','supporting_equipment') || $check_field('set','supporting_equipment')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="配套设备" prop="supporting_equipment">
												<el-input id="supporting_equipment" v-model="form['supporting_equipment']" placeholder="请输入配套设备"
							  v-if="user_group === '管理员' || (form['dormitory_management_id'] && $check_field('set','supporting_equipment')) || (!form['dormitory_management_id'] && $check_field('add','supporting_equipment'))" :disabled="disabledObj['supporting_equipment_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','supporting_equipment')">{{form['supporting_equipment']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','responsible_for_dormitory_management') || $check_field('add','responsible_for_dormitory_management') || $check_field('set','responsible_for_dormitory_management')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="负责宿管" prop="responsible_for_dormitory_management">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_responsible_for_dormitory_management(form['responsible_for_dormitory_management']) }}
							<!--<el-input id="business_name" v-model="form['responsible_for_dormitory_management']" placeholder="请输入负责宿管"-->
							<!--v-if="user_group === '管理员' || (form['dormitory_management_id'] && $check_field('set','responsible_for_dormitory_management')) || (!form['dormitory_management_id'] && $check_field('add','responsible_for_dormitory_management'))" :disabled="disabledObj['responsible_for_dormitory_management_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','responsible_for_dormitory_management')">{{form['responsible_for_dormitory_management']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['dormitory_management_id'] && $check_field('set','responsible_for_dormitory_management')) || (!form['dormitory_management_id'] && $check_field('add','responsible_for_dormitory_management'))" id="responsible_for_dormitory_management" v-model="form['responsible_for_dormitory_management']" :disabled="disabledObj['responsible_for_dormitory_management_isDisabled']">
								<el-option v-for="o in list_user_responsible_for_dormitory_management" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','responsible_for_dormitory_management')" id="responsible_for_dormitory_management" v-model="form['responsible_for_dormitory_management']" :disabled="true">
								<el-option v-for="o in list_user_responsible_for_dormitory_management" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="responsible_for_dormitory_management" v-model="form['responsible_for_dormitory_management']" :disabled="disabledObj['responsible_for_dormitory_management_isDisabled']">
							<el-option v-for="o in list_user_responsible_for_dormitory_management" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','name_of_accommodation_manager') || $check_field('add','name_of_accommodation_manager') || $check_field('set','name_of_accommodation_manager')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="宿管姓名" prop="name_of_accommodation_manager">
												<el-input id="name_of_accommodation_manager" v-model="form['name_of_accommodation_manager']" placeholder="请输入宿管姓名"
							  v-if="user_group === '管理员' || (form['dormitory_management_id'] && $check_field('set','name_of_accommodation_manager')) || (!form['dormitory_management_id'] && $check_field('add','name_of_accommodation_manager'))" :disabled="disabledObj['name_of_accommodation_manager_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_accommodation_manager')">{{form['name_of_accommodation_manager']}}</div>
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
				field: "dormitory_management_id",
				url_add: "~/api/dormitory_management/add?",
				url_set: "~/api/dormitory_management/set?",
				url_get_obj: "~/api/dormitory_management/get_obj?",
				url_upload: "~/api/dormitory_management/upload?",

				query: {
					"dormitory_management_id": 0,
				},

				form: {
								"dormitory_name":  '', // 宿舍名称
										"dormitory_type":  '', // 宿舍类型
										"number_of_beds":  0, // 床位数量
										"located_in_the_building":  '', // 所在楼宇
										"supporting_equipment":  '', // 配套设备
										"responsible_for_dormitory_management": 0, // 负责宿管
										"name_of_accommodation_manager":  '', // 宿管姓名
											"dormitory_management_id": 0, // ID
						
				},
				disabledObj:{
								"dormitory_name_isDisabled": false,
										"dormitory_type_isDisabled": false,
					          			"number_of_beds_isDisabled": false,
										"located_in_the_building_isDisabled": false,
										"supporting_equipment_isDisabled": false,
										"responsible_for_dormitory_management_isDisabled": false,
										"name_of_accommodation_manager_isDisabled": false,
										},

	
		
		
						// 所在楼宇选项列表
				list_located_in_the_building: [""],
	
		
		
					// 用户列表
				list_user_responsible_for_dormitory_management: [],
						// 用户组
				group_user_responsible_for_dormitory_management: "",
				
	
			}
		},
		methods: {


	
	
			
	
			
	
			
				/**
			 * 获取所在楼宇列表
			 */
			async get_list_located_in_the_building() {
				var json = await this.$get("~/api/building_management/get_list?");
				if(json.result && json.result.list){
					this.list_located_in_the_building = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
				/**
			 * 获取宿管员用户列表
			 */
			async get_list_user_responsible_for_dormitory_management() {
                // if(this.user_group !== "管理员" && this.form["responsible_for_dormitory_management"] === 0) {
                //     this.form["responsible_for_dormitory_management"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=宿管员");
                if(json.result && json.result.list){
                    this.list_user_responsible_for_dormitory_management = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					/**
			 * 获取宿管员用户组
			 */
			async get_group_user_responsible_for_dormitory_management() {
							this.form["responsible_for_dormitory_management"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=宿管员");
				if(json.result && json.result.obj){
					this.group_user_responsible_for_dormitory_management = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_responsible_for_dormitory_management(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_responsible_for_dormitory_management.source_table+"/get_obj?"
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
												_this.form["responsible_for_dormitory_management"] = id
									_this.disabledObj['responsible_for_dormitory_management' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "responsible_for_dormitory_management") {
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
					get_user_responsible_for_dormitory_management(id){
				var obj = this.list_user_responsible_for_dormitory_management.getObj({"user_id":id});
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
																		$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


																					


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
					bl = this.$check_action('/dormitory_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/dormitory_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/dormitory_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/dormitory_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/dormitory_management/view','get');
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
										this.get_list_located_in_the_building();
									this.get_list_user_responsible_for_dormitory_management();
					this.get_group_user_responsible_for_dormitory_management();
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
