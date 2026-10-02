<template>
	<div>
			<el-form-item v-if="$check_register_field('add','student_no','/student/view')" label="学生编号" prop="student_no">
				<el-input id="student_no" v-model="form['student_no']" placeholder="请输入学生编号"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','student_name','/student/view')" label="学生姓名" prop="student_name">
				<el-input id="student_name" v-model="form['student_name']" placeholder="请输入学生姓名"></el-input>
				</el-form-item>
				<el-form-item v-if="$check_register_field('add','gender','/student/view')" label="性别" prop="gender">
				<el-select id="gender" v-model="form['gender']">
			<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
				</el-form-item>
	
	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		props:{

			form:{
				type: Object,
				default: function(){
					return {
							"student_no":  '' ,
								"student_name":  '' ,
								"gender":  '' ,
						}
				}
			},

		},
		data() {
			return {
				field: "student_id",
				url_add: "~/api/student/add?",
				url_set: "~/api/student/set?",
				url_upload: "~/api/student/upload?",

							list_gender: ['男','女'],
	
				rules: {
					"student_no": [    {required: true,message: '学生编号不能为空'},  ],
					"student_name": [    {required: true,message: '学生姓名不能为空'},  ],
					"gender": [    {required: true,message: '性别不能为空'},  ],
				}

			}
		},
		methods: {

	
	
	

	
	
	

	
	
	

		},
		created() {
					}
	}
</script>
