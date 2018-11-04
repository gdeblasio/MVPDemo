package mvpdemo;

public class Presenter {
    private final View view;
    private final Model model;

    public Presenter(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    
    public void login(String pass) {
        String result = "Incorrect Password";
        
        if (model.getPassword().equals(pass)) {
            result = "Correct Password";
            view.hideInputField();
        }
        
        // Se actualiza la vista según dicta MVP
        view.updateStatusLabel(result); 
    }
}
