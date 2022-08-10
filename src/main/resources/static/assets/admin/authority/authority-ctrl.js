app.controller("authority-ctrl", function($scope, $http){
    $scope.roles=[];
    $scope.admins=[];
    $scope.authorities=[];

    $scope.initialize=function () {
        $http.get("/rest/roles").then(resp=>{
            $scope.roles=resp.data;
        })

        $http.get("/rest/accounts?admin=false").then(resp=>{
            $scope.admins=resp.data;
        })

        $http.get("/rest/authorities?admin=false").then(resp => {
            $scope.authorities = resp.data;
        }).catch(e=>{
            $location.path("/unauthorized");
        })
    }


    $scope.authority_of=function (acc,role) {
        if ($scope.authorities){
            return $scope.authorities.find(ur=>ur.account.username==acc.username && ur.role.id==role.id);
        }
    }
    $scope.authority_changed = function (acc,role) {
        var authority = $scope.authority_of(acc,role);
        if (authority){//thu hoi quyen
            $scope.revoke_authority(authority);
        }else {//chua duoc cap quyen=>cap quyen(them moi)
            authority={account:acc,role:role};
            $scope.grant_authority(authority);
        }
    }

    $scope.grant_authority = function (authority) {
        $http.post(`/rest/authorities`,authority).then(resp=>{
            $scope.authorities.push(resp.data)
            alert("Cap quyen su dung thanh cong");
        }).catch(e=>{
            alert("cq loi")
            console.log(e);
        })
    }
    
    $scope.revoke_authority = function (authority) {
        $http.delete(`/rest/authorities/${authority.id}`).then(resp=>{
            var index =$scope.authorities.findIndex(a=>a.id == authority.id);
            $scope.authorities.slice(index,1);
            alert("Thu hoi quyen thanh cong");
        }).catch(e=>{
            alert("thu hoi loi")
            console.log(e);
        })
    }
    $scope.initialize();
});