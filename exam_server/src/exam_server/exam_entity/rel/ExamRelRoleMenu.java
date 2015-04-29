package exam_entity.rel;



/**
 * ExamRelRoleMenu entity. @author MyEclipse Persistence Tools
 */

public class ExamRelRoleMenu  implements java.io.Serializable {


    // Fields    

     private Long role_menu_id;
     private Long role_id;
     private Long menu_id;


    // Constructors

    /** default constructor */
    public ExamRelRoleMenu() {
    }

    
    /** full constructor */
    public ExamRelRoleMenu(Long role_id, Long menu_id) {
        this.role_id = role_id;
        this.menu_id = menu_id;
    }

   
    // Property accessors

    public Long getRole_menu_id() {
        return this.role_menu_id;
    }
    
    public void setRole_menu_id(Long role_menu_id) {
        this.role_menu_id = role_menu_id;
    }

    public Long getRole_id() {
        return this.role_id;
    }
    
    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getMenu_id() {
        return this.menu_id;
    }
    
    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }
   








}