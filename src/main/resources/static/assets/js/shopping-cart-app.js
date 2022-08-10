var app =angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl", function ($scope,$http){
    // QL GIOR HANG
    $scope.cart= {
        items:[],
        user:"",
        //Them vao cart
        add(id){
            var item = this.items.find(item=>item.id ==id);
            if (item){
                item.qty++;
                this.saveToLocalStorage();
            }
            else {
                $http.get(`/rest/products/${id}`).then(resp=>{
                    resp.data.qty =1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        //xoa sp khoi cart
        remove(id){
            var index = this.items.findIndex(item=>item.id == id);
            this.items.splice(index,1);
            this.saveToLocalStorage();
        }
        ,
        //Tong sl mat hang trong gio
        get count(){
            return this.items
                .map(item=>item.qty)
                .reduce((total,qty)=>total +=qty,0)
        }
        ,
        //Tong tien cac mat hang trong gio
        get amount(){
            return this.items
                .map(item=>item.qty * item.price)
                .reduce((total,qty)=>total +=qty,0)
        }
        ,
        clear(){
            this.items= [];
            this.saveToLocalStorage();
        }
        ,
        //Luu cart vao local storage
        saveToLocalStorage(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
        },
        //Doc cart tu local storage
        loadFromLocalStorage(){
            var json = localStorage.getItem("cart");
            this.items = json? JSON.parse(json):[];
        },
    },
    $scope.cart.loadFromLocalStorage();
    var user = document.getElementById("username");
    var username="";
    if (user!=null){
        username= user.textContent;
    }
        $scope.order = {
            createDate : new Date(),
            address:"",
            account: {username:username},
            get orderDetails(){
                return $scope.cart.items.map(item=>{
                    return {
                        product:{id:item.id},
                        price:item.price,
                        quantity:item.qty
                    }
                });
            },
            purchase(){
                var order = angular.copy(this);
                //thuc hien dat hang
                $http.post("/rest/orders",order).then(resp=>{
                    alert("Dat hang thanh cong");
                    $scope.cart.clear();
                    location.href="/order/detail/"+resp.data.id;
                }).catch(error=>{
                    alert("Dat hang loi");
                    console.log(error)
                })
            }
        }


})