/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package networking;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class EmailView extends BorderPane
{
    private Image backgroundImg = new Image("images/hbOrange.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.NO_REPEAT, 
                                                    BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, bSize));
    //forms
    //private EmailForm emailForm = new EmailForm();
    private AuthenticationForm authenticationForm = new AuthenticationForm();
    
    public EmailView()
    {
        this.setBackground(background);
        //this.setCenter(emailForm);
    }

    /**
     * @return the loginForm
     */
    public EmailForm GetEmailForm()
    {
        //return emailForm;
        return null;
    }

    /**
     * @param emailForm the loginForm to set
     */
    public void SetEmailForm(EmailForm emailForm)
    {
        //this.emailForm = emailForm;
    }
    
    /**
     * @return the authenticationForm
     */
    public AuthenticationForm GetAuthenticationForm()
    {
        return authenticationForm;
    }

    /**
     * @param authenticationForm the authenticationForm to set
     */
    public void SetAuthenticationForm(AuthenticationForm authenticationForm)
    {
        this.authenticationForm = authenticationForm;
    }
    
    //functions
    public void SetEmailForm()
    {
        this.getChildren().clear();
        //this.setCenter(emailForm);
    }

    public void SetAuthenticationForm()
    {
        this.getChildren().clear();
        this.setCenter(authenticationForm);
    }
}
