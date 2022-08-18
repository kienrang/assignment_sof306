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
        .when("/account", {
            templateUrl: "/assets/admin/accounts/index1.html",
            control: "acc-ctrl"
        })
        .otherwise({
            template: "FPT Polytechnic"

        });
});