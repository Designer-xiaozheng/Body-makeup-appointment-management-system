import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
import register from '../views/register.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},

	// 注册
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {
			index: 0,
			title: '注册'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},








	// 学生路由
	{
		path: '/student/table',
		name: 'student_table',
		component: () => import('../views/student/table.vue'),
		meta: {
			index: 0,
			title: '学生列表'
		}
	},
	{
		path: '/student/view',
		name: 'student_view',
		component: () => import('../views/student/view.vue'),
		meta: {
			index: 0,
			title: '学生详情'
		}
	},
	// 宿管员路由
	{
		path: '/houseparent/table',
		name: 'houseparent_table',
		component: () => import('../views/houseparent/table.vue'),
		meta: {
			index: 0,
			title: '宿管员列表'
		}
	},
	{
		path: '/houseparent/view',
		name: 'houseparent_view',
		component: () => import('../views/houseparent/view.vue'),
		meta: {
			index: 0,
			title: '宿管员详情'
		}
	},
	// 维修员路由
	{
		path: '/maintenance_personnel/table',
		name: 'maintenance_personnel_table',
		component: () => import('../views/maintenance_personnel/table.vue'),
		meta: {
			index: 0,
			title: '维修员列表'
		}
	},
	{
		path: '/maintenance_personnel/view',
		name: 'maintenance_personnel_view',
		component: () => import('../views/maintenance_personnel/view.vue'),
		meta: {
			index: 0,
			title: '维修员详情'
		}
	},
	// 楼宇管理路由
	{
		path: '/building_management/table',
		name: 'building_management_table',
		component: () => import('../views/building_management/table.vue'),
		meta: {
			index: 0,
			title: '楼宇管理列表'
		}
	},
	{
		path: '/building_management/view',
		name: 'building_management_view',
		component: () => import('../views/building_management/view.vue'),
		meta: {
			index: 0,
			title: '楼宇管理详情'
		}
	},
	// 宿舍管理路由
	{
		path: '/dormitory_management/table',
		name: 'dormitory_management_table',
		component: () => import('../views/dormitory_management/table.vue'),
		meta: {
			index: 0,
			title: '宿舍管理列表'
		}
	},
	{
		path: '/dormitory_management/view',
		name: 'dormitory_management_view',
		component: () => import('../views/dormitory_management/view.vue'),
		meta: {
			index: 0,
			title: '宿舍管理详情'
		}
	},
	// 学生信息路由
	{
		path: '/student_information/table',
		name: 'student_information_table',
		component: () => import('../views/student_information/table.vue'),
		meta: {
			index: 0,
			title: '学生信息列表'
		}
	},
	{
		path: '/student_information/view',
		name: 'student_information_view',
		component: () => import('../views/student_information/view.vue'),
		meta: {
			index: 0,
			title: '学生信息详情'
		}
	},
	// 申请换寝路由
	{
		path: '/apply_for_a_change_of_bed/table',
		name: 'apply_for_a_change_of_bed_table',
		component: () => import('../views/apply_for_a_change_of_bed/table.vue'),
		meta: {
			index: 0,
			title: '申请换寝列表'
		}
	},
	{
		path: '/apply_for_a_change_of_bed/view',
		name: 'apply_for_a_change_of_bed_view',
		component: () => import('../views/apply_for_a_change_of_bed/view.vue'),
		meta: {
			index: 0,
			title: '申请换寝详情'
		}
	},
	// 请假报备路由
	{
		path: '/leave_reporting/table',
		name: 'leave_reporting_table',
		component: () => import('../views/leave_reporting/table.vue'),
		meta: {
			index: 0,
			title: '请假报备列表'
		}
	},
	{
		path: '/leave_reporting/view',
		name: 'leave_reporting_view',
		component: () => import('../views/leave_reporting/view.vue'),
		meta: {
			index: 0,
			title: '请假报备详情'
		}
	},
	// 报修申请路由
	{
		path: '/repair_application/table',
		name: 'repair_application_table',
		component: () => import('../views/repair_application/table.vue'),
		meta: {
			index: 0,
			title: '报修申请列表'
		}
	},
	{
		path: '/repair_application/view',
		name: 'repair_application_view',
		component: () => import('../views/repair_application/view.vue'),
		meta: {
			index: 0,
			title: '报修申请详情'
		}
	},
	// 问题反馈路由
	{
		path: '/problem_feedback/table',
		name: 'problem_feedback_table',
		component: () => import('../views/problem_feedback/table.vue'),
		meta: {
			index: 0,
			title: '问题反馈列表'
		}
	},
	{
		path: '/problem_feedback/view',
		name: 'problem_feedback_view',
		component: () => import('../views/problem_feedback/view.vue'),
		meta: {
			index: 0,
			title: '问题反馈详情'
		}
	},
	// 缺寝登记路由
	{
		path: '/lack_of_bed_registration/table',
		name: 'lack_of_bed_registration_table',
		component: () => import('../views/lack_of_bed_registration/table.vue'),
		meta: {
			index: 0,
			title: '缺寝登记列表'
		}
	},
	{
		path: '/lack_of_bed_registration/view',
		name: 'lack_of_bed_registration_view',
		component: () => import('../views/lack_of_bed_registration/view.vue'),
		meta: {
			index: 0,
			title: '缺寝登记详情'
		}
	},
	// 迁出记录路由
	{
		path: '/migration_records/table',
		name: 'migration_records_table',
		component: () => import('../views/migration_records/table.vue'),
		meta: {
			index: 0,
			title: '迁出记录列表'
		}
	},
	{
		path: '/migration_records/view',
		name: 'migration_records_view',
		component: () => import('../views/migration_records/view.vue'),
		meta: {
			index: 0,
			title: '迁出记录详情'
		}
	},
	// 报修记录路由
	{
		path: '/repair_record/table',
		name: 'repair_record_table',
		component: () => import('../views/repair_record/table.vue'),
		meta: {
			index: 0,
			title: '报修记录列表'
		}
	},
	{
		path: '/repair_record/view',
		name: 'repair_record_view',
		component: () => import('../views/repair_record/view.vue'),
		meta: {
			index: 0,
			title: '报修记录详情'
		}
	},
	// 公告管理路由
	{
		path: '/announcement_management/table',
		name: 'announcement_management_table',
		component: () => import('../views/announcement_management/table.vue'),
		meta: {
			index: 0,
			title: '公告管理列表'
		}
	},
	{
		path: '/announcement_management/view',
		name: 'announcement_management_view',
		component: () => import('../views/announcement_management/view.vue'),
		meta: {
			index: 0,
			title: '公告管理详情'
		}
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "学生宿舍管理系统-admin";
	document.title = title;
})

export default router
