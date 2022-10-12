/*
父类泛型对象可以赋值给子类泛型对象，用 in
子类泛型对象可以赋值给父类泛型对象，用 out*/

/*假如定义了一个MyClass<T>的泛型类，其中A是B的子类，
同时MyClass<A>是MyClass<B>的子类的话，
那么我们就可以说MyClass在T这个泛型上是协变out的*/

/*假如定义了一个MyClass<T>的泛型类，其中A是B的子类，
同时MyClass<B>是MyClass<A>的子类的话，
那么我们就可以说MyClass在T这个泛型上是逆变的*/

class Barrel<in/*out*/ T>(/*val*/ item: T)

fun main() {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

//    lootBarrel = fedoraBarrel
    fedoraBarrel = lootBarrel
//    lootBarrel.item = Coin(15)
//    val myFedora: Fedora = fedoraBarrel.item
//    val myFedora: Fedora = lootBarrel.item


}


