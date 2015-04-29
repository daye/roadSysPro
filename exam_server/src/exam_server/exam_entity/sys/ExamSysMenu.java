package exam_entity.sys;



/**
 * ExamSysMenu entity. @author MyEclipse Persistence Tools
 */

public class ExamSysMenu  implements java.io.Serializable {


    // Fields    

     private Long menu_id;
     private String menu_name;
     private Long parent_menu_id;
     private String menu_page;
     private Boolean status;
     private Long menu_order;


    // Constructors

    public Long getMenu_order() {
		return menu_order;
	}

	public void setMenu_order(Long menu_order) {
		this.menu_order = menu_order;
	}

	/** default constructor */
    public ExamSysMenu() {
    }

	/** minimal constructor */
    public ExamSysMenu(Long menu_id, String menu_name, Long parent_menu_id, Boolean status) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.parent_menu_id = parent_menu_id;
        this.status = status;
    }
    
    /** full constructor */
    public ExamSysMenu(Long menu_id, String menu_name, Long parent_menu_id, String menu_page, Boolean status) {
        this.menu_id = menu_id;
        this.menu_name = menu_name;
        this.parent_menu_id = parent_menu_id;
        this.menu_page = menu_page;
        this.status = status;
    }

   
    // Property accessors

    public Long getMenu_id() {
        return this.menu_id;
    }
    
    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return this.menu_name;
    }
    
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public Long getParent_menu_id() {
        return this.parent_menu_id;
    }
    
    public void setParent_menu_id(Long parent_menu_id) {
        this.parent_menu_id = parent_menu_id;
    }

    public String getMenu_page() {
        return this.menu_page;
    }
    
    public void setMenu_page(String menu_page) {
        this.menu_page = menu_page;
    }

    public Boolean getStatus() {
        return this.status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }
   








}