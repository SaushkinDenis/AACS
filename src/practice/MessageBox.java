package practice;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MessageBox {
    protected static boolean result = false;
   
    public static boolean messRemove(){
        
        JOptionPane optionPaneRechange = new JOptionPane();
        UIManager.put("OptionPane.yesButtonText", "Ок");
        UIManager.put("OptionPane.noButtonText", "Отмена");
        optionPaneRechange.updateUI();
        int resultQuestion = optionPaneRechange.showConfirmDialog(null, "Подтвердите удаление записи.", "Подтверждение редактирования!", 
	optionPaneRechange.YES_NO_OPTION, optionPaneRechange.QUESTION_MESSAGE);

        switch(resultQuestion){
	    case JOptionPane.YES_OPTION: 
                result = true;
                break;
	    case JOptionPane.NO_OPTION: 
                result = false; 
                break;
	    case JOptionPane.CLOSED_OPTION:  break;
	    default: break;
	    }
        
        return result;
        
    }
    public static boolean messChange(){
        
        JOptionPane optionPaneRechange = new JOptionPane();
        UIManager.put("OptionPane.yesButtonText", "Ок");
        UIManager.put("OptionPane.noButtonText", "Отмена");
        optionPaneRechange.updateUI();
        int resultQuestion = optionPaneRechange.showConfirmDialog(null, "Подтвердите редактирование записи.", "Подтверждение редактирования!", 
	optionPaneRechange.YES_NO_OPTION, optionPaneRechange.QUESTION_MESSAGE);

        switch(resultQuestion){
	    case JOptionPane.YES_OPTION: 
                result = true;
                break;
	    case JOptionPane.NO_OPTION: 
                result = false; 
                break;
	    case JOptionPane.CLOSED_OPTION:  break;
	    default: break;
	    }
        
        return result;
        
    }
    public static void messMiss(){
       JOptionPane.showConfirmDialog(null, "Заполните поля", "Внимание!",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);  
    }
    public static String notificationSetRole(String role, ArrayList setRole){
        JOptionPane optionPaneFact = new JOptionPane();
        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        optionPaneFact.updateUI();
        
        int result = optionPaneFact.showConfirmDialog(null, "Новому пользователю будет соответствовать следующая роль: "+role+ ". Выбрать роль вручную?", "Подтверждение роли!",
        optionPaneFact.YES_NO_OPTION, optionPaneFact.QUESTION_MESSAGE);
        
        switch(result){
            case JOptionPane.YES_OPTION:
                Object changeRole = JOptionPane.showInputDialog(null,"Выберите роль","Выбор роли",JOptionPane.QUESTION_MESSAGE, null, setRole.toArray(), setRole.get(0) );
                role = (String) changeRole;
                break;
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CLOSED_OPTION:
                break;
            default:
                break;
        }
        return role;
    }
    
}
