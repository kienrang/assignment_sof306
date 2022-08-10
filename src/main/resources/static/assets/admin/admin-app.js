app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/product", {
            templateUrl: "/assets/admin/product/index.html",
            control: "product-ctrl"
        })
        .when("/authorize", {
            templateUrl: "/assets/admin/authority/index.html",
            control: "authority-ctrl"
        })
        .when("/unauthorize", {
            templateUrl: "/assets/admin/authority/unauthorize.html",
            control: "authority-ctrl"
        })
        .otherwise({
            template: "FPT Polytechnic"
        });
});