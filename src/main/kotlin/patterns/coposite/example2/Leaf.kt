package patterns.coposite.example2

class Manager(private val empId: Long, private val name: String, private val position: String) : Employee {
    override fun showEmployeeDetails() {
        println("$empId $name")
    }
}