<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','title') || $check_field('add','title') || $check_field('set','title')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="标题" prop="title">
												<el-input id="title" v-model="form['title']" placeholder="请输入标题"
							  v-if="user_group === '管理员' || (form['announcement_management_id'] && $check_field('set','title')) || (!form['announcement_management_id'] && $check_field('add','title'))" :disabled="disabledObj['title_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','title')">{{form['title']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','housing_management_number') || $check_field('add','housing_management_number') || $check_field('set','housing_management_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="宿管编号" prop="housing_management_number">
																		<div v-if="user_group !== '管理员'">
							{{ get_user_session_housing_management_number(form['housing_management_number']) }}
							<!--<el-input id="business_name" v-model="form['housing_management_number']" placeholder="请输入宿管编号"-->
							<!--v-if="user_group === '管理员' || (form['announcement_management_id'] && $check_field('set','housing_management_number')) || (!form['announcement_management_id'] && $check_field('add','housing_management_number'))" :disabled="disabledObj['housing_management_number_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','housing_management_number')">{{form['housing_management_number']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['announcement_management_id'] && $check_field('set','housing_management_number')) || (!form['announcement_management_id'] && $check_field('add','housing_management_number'))" id="housing_management_number" v-model="form['housing_management_number']" :disabled="disabledObj['housing_management_number_isDisabled']">
								<el-option v-for="o in list_user_housing_management_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','housing_management_number')" id="housing_management_number" v-model="form['housing_management_number']" :disabled="true">
								<el-option v-for="o in list_user_housing_management_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="housing_management_number" v-model="form['housing_management_number']" :disabled="disabledObj['housing_management_number_isDisabled']">
							<el-option v-for="o in list_user_housing_management_number" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
																</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','name_of_accommodation_manager') || $check_field('add','name_of_accommodation_manager') || $check_field('set','name_of_accommodation_manager')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="宿管姓名" prop="name_of_accommodation_manager">
												<el-input id="name_of_accommodation_manager" v-model="form['name_of_accommodation_manager']" placeholder="请输入宿管姓名"
							  v-if="user_group === '管理员' || (form['announcement_management_id'] && $check_field('set','name_of_accommodation_manager')) || (!form['announcement_management_id'] && $check_field('add','name_of_accommodation_manager'))" :disabled="disabledObj['name_of_accommodation_manager_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','name_of_accommodation_manager')">{{form['name_of_accommodation_manager']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','release_time') || $check_field('add','release_time') || $check_field('set','release_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="发布时间" prop="release_time">
								<el-date-picker :disabled="disabledObj['release_time_isDisabled']" v-if="user_group === '管理员' || (form['announcement_management_id'] && $check_field('set','release_time')) || (!form['announcement_management_id'] && $check_field('add','release_time'))" id="release_time"
						v-model="form['release_time']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','release_time')">{{form['release_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','content_details') || $check_field('add','content_details') || $check_field('set','content_details')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="内容详情" prop="content_details">
								<el-input type="textarea" id="content_details" v-model="form['content_details']" placeholder="请输入内容详情"
						v-if="user_group === '管理员' || (form['announcement_management_id'] && $check_field('set','content_details')) || (!form['announcement_management_id'] && $check_field('add','content_details'))" :disabled="disabledObj['content_details_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','content_details')">{{form['content_details']}}</div>
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
				field: "announcement_management_id",
				url_add: "~/api/announcement_management/add?",
				url_set: "~/api/announcement_management/set?",
				url_get_obj: "~/api/announcement_management/get_obj?",
				url_upload: "~/api/announcement_management/upload?",

				query: {
					"announcement_management_id": 0,
				},

				form: {
								"title":  '', // 标题
										"housing_management_number": 0, // 宿管编号
										"name_of_accommodation_manager":  '', // 宿管姓名
										"release_time":  '', // 发布时间
										"content_details":  '', // 内容详情
											"announcement_management_id": 0, // ID
						
				},
				disabledObj:{
								"title_isDisabled": false,
										"housing_management_number_isDisabled": false,
										"name_of_accommodation_manager_isDisabled": false,
										"release_time_isDisabled": false,
										"content_details_isDisabled": false,
										},

	
		
					// 用户列表
				list_user_housing_management_number: [],
						// 用户组
				group_user_housing_management_number: "",
				
		
		
	
			}
		},
		methods: {


	
	
			
	
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
					/**
			 * 获取宿管员用户组
			 */
			async get_group_user_housing_management_number() {
							this.form["housing_management_number"] = this.user.user_id;
							var json = await this.$get("~/api/user_group/get_obj?name=宿管员");
				if(json.result && json.result.obj){
					this.group_user_housing_management_number = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_housing_management_number(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_housing_management_number.source_table+"/get_obj?"
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
												_this.form["housing_management_number"] = id
									_this.disabledObj['housing_management_number' + '_isDisabled'] = true
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
							for (var j = 0; j < arrForm.length; j++) {
							  if (arr[i] === arrForm[j]) {
								if (arr[i] !== "housing_management_number") {
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
								        if (this.form["release_time"].indexOf("-")===-1){
          this.form["release_time"] = this.$toTime(parseInt(this.form["release_time"]),"yyyy-MM-dd")
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


											        if(this.form["release_time"]=="0000-00-00"){
          this.form["release_time"] = null;
        }
				if(parseInt(this.form["release_time"]) > 9999){
					this.form["release_time"] = this.$toTime(parseInt(this.form["release_time"]),"yyyy-MM-dd")
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
					bl = this.$check_action('/announcement_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/announcement_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/announcement_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/announcement_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/announcement_management/view','get');
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
							this.get_list_user_housing_management_number();
					this.get_group_user_housing_management_number();
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
