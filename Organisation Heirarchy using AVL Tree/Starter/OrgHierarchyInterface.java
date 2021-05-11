public interface OrgHierarchyInterface {
	public boolean isEmpty();  /* Returns true if the organization is empty. */
	public int size();  /* Returns the number of employees in the organization */ 	
	public int level(int id) throws IllegalIDException, EmptyTreeException;  /* Returns the level of the employee with ID=id */ 	

	public void hireOwner(int id) throws NotEmptyException;  /* Adds the first employee of the organization, which we call the owner. There is only one owner in an org who cannot be deleted. */
	public void hireEmployee(int id, int bossid) throws IllegalIDException, EmptyTreeException;  /* Adds a new employee whose ID is id. This employee will work under an existing employee whose ID is bossid (note that this automatically decides the level of id, it is one more than that of bossid). */
	public void fireEmployee(int id) throws IllegalIDException, EmptyTreeException;  /* Deletes an employee who does not manage any other employees. Note that this can not be the owner. If it is the owner, throw the IllegalIDException. */
	public void fireEmployee(int id, int manageid) throws IllegalIDException, EmptyTreeException;  /* Deletes an employee (id) who might manage other employees. Manageid is another employee who works at the same level as id. All employees working under id will now work under manageid. Note that this can not be the owner. If it is the owner, throw the IllegalIDException. */

	public int boss(int id) throws IllegalIDException, EmptyTreeException;  /* Returns the id of the immediate boss, the employee. Output -1 if id is the owner’s ID  */
	public int lowestCommonBoss(int id1, int id2) throws IllegalIDException, EmptyTreeException;  /* Returns the ID of the employee A who is a boss of both id1 and id2, and among all such persons has the largest level. In other words, we want to find the common boss who is lowest in the hierarchy in the company. If one of the input ids is the owner, output -1 */

	public String toString(int id) throws IllegalIDException, EmptyTreeException; /* This method returns a string that contains the IDs of all the employees of the organisation rooted at id. It should contain the employees level-wise. So first it should have id, then ids of all the employees directly under id, and then all employees directly these employees and so on. Make sure that in the string levels are comma separated and employees inside a level are space separated. Among employees at the same level, the output should be sorted in increasing order of the ids.*/
}

