const dynamicUser = [
    {
        name: "管理员",
        avatar: require('@/assets/images/huahua.png'),
        desc: "管理员 - admin",
        username: "admin",
        password: "654321",
        token: "rtVrM4PhiFK8PNopqWuSjsc1n02oKc3f",
        routes: [
            { id: 1, name: "/", path: "/", component: "pageComponent", redirect: "/index", hidden: false, children: [
                    { name: "index", path: "/index", meta: { title: "index" }, component: "index/index" },
                ]},
            // { id: 1, name: "/", path: "/", component: "Layout", redirect: "/index", hidden: false, children: [
            //     { name: "index", path: "/index", meta: { title: "index" }, component: "index/index" },
            // ]},
            // { id: 2, name: "/admin", path: "/admin", component: "Layout", redirect: "/admin/index", hidden: false, children: [
            //         { name: "/admin/index", path: "/admin/index", meta: { title: "admin" }, component: "admin/index" }
            //     ] },
            // { id: 3, name: "/example", path: "/example", component: "Layout", redirect: "/example/tree", meta: { title: "example" }, hidden: false, children: [
            //     { name: "/tree", path: "/example/tree", meta: { title: "tree" }, component: "tree/index" },
            //     { name: "/copy", path: "/example/copy", meta: { title: "copy" }, component: "tree/copy" }
            // ] },
        ]
    },
    {
        name: "普通用户",
        avatar: "https://sf1-ttcdn-tos.pstatp.com/img/user-avatar/6364348965908f03e6a2dd188816e927~300x300.image",
        desc: "普通用户 - people",
        username: "people",
        password: "123456",
        token: "4es8eyDwznXrCX3b3439EmTFnIkrBYWh",
        routes: [
            { id: 1, name: "/", path: "/", component: "Layout", redirect: "/index", hidden: false, children: [
                    { name: "index", path: "/index", meta: { title: "index" }, component: "index/index" },
                ]},
            { id: 2, name: "/admin", path: "/admin", component: "Layout", redirect: "/admin/index", hidden: false, children: [
                    { name: "/admin/index", path: "/admin/index", meta: { title: "admin" }, component: "admin/index" }
                ] },
            { id: 3, name: "/example", path: "/example", component: "Layout", redirect: "/example/tree", meta: { title: "example" }, hidden: false, children: [
                    { name: "/tree", path: "/example/tree", meta: { title: "tree" }, component: "tree/index" },
                    { name: "/copy", path: "/example/copy", meta: { title: "copy" }, component: "tree/copy" }
                ] },
        ]
    }
]

export default dynamicUser