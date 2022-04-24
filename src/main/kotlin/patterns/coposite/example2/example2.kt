package patterns.coposite.example2

fun main(){
    val dev1 = Developer(100, "Lokesh Sharma", "Pro Developer")
    val dev2 = Developer(101, "Vinay Sharma", "Developer")
    val engDirectory = CompanyDirectory()
    engDirectory.addEmployee(dev1)
    engDirectory.addEmployee(dev2)

    val man1 = Manager(200, "Kushagra Garg", "SEO Manager")
    val man2 = Manager(201, "Vikram Sharma ", "Kushagra's Manager")

    val accDirectory = CompanyDirectory()
    accDirectory.addEmployee(man1)
    accDirectory.addEmployee(man2)

    val directory = CompanyDirectory()
    directory.addEmployee(engDirectory)
    directory.addEmployee(accDirectory)
    directory.showEmployeeDetails()
}