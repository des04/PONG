
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    //TODO (44): Declare an integer instance constant called SIZE that is initialized to 20
    private final int SIZE = 20;

    //TODO (45): Declare a static integer instance variable (private static int) called velocity initialized to 0
    private static int velocity = 0;

    /**
     * Ball is the constructor for ball
     * 
     * @param None There are no parameters
     * @return There is no return type
     * 
     * TODO (46): Declare a default constructor for the Ball class
     * 
     * TODO (47): Inside the method, declare a local GreenfootImage variable called ballImage
     *            initialized to a new GrenfootImage object that has a width 
     *            of SIZE and a height of SIZE
     * 
     * TODO (48): Set the color of the ballImage to WHITE
     * 
     * TODO (49): Fill an oval on the ballImage that starts at (0,0) and has a width of SIZE and a height of SIZE
     * 
     * TODO (50): Set the image of the Ball class to the ballImage
     * 
     * TODO (51): Turn the ball a random number of degrees between 0 and 360 (360 not included)
     */
    public Ball()
    {
        GreenfootImage ballImage = new GreenfootImage( SIZE, SIZE );
        ballImage.setColor(Color.WHITE);
        ballImage.fillOval( 0, 0, SIZE, SIZE );
        setImage( ballImage );
        turn(Greenfoot.getRandomNumber(360));
    }

    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        //TODO (82): Declare a local PlayField variable called field that is initialized to store a reference to the PlayField object
        PlayField field = (PlayField)getWorld();

        //TODO (83): If the game has started (PlayField has a method for checking this)...
        if ( field.getStarted() == true )
        {
            //TODO (84): Move the ball at a speed of velocity
            move(velocity);

            //TODO (107): Use a method to check if the ball has collided with something
            checkCollision();
        }
    }

    /**
     * checkCollision is the method that checks to see whenever the ball hits
     * something. If the ball hits a paddle/the top or bottom of the screen
     * it'll bounce back at a different angle, if the ball hits the side of
     * the screen the game resets but with an extra point added to the player
     * that hit the ball last.
     * 
     * @param None There are no parameters
     * @return There isn't a return type / nothing is returned
     * 
     * TODO (85): Declare a method called checkCollision that does not
     *          return anything and has no parameters
     *          
     * TODO (86): Inside the method, declare a local Actor variable called hitting
     *            that is initialized to an intersecting object of class Paddle 
     *            (use the getOneIntersectingObject method, which can be found in the Actor documentation)
     * 
     * TODO (87): Declare a local PlayField variable called world that is initialized
     *            to a reference to the PlayField object
     * 
     * TODO (88): Declare a local Score variable called getPoint
     * 
     * TODO (89): If the hitting object is not nothing (i.e. != null)...
     * 
     *      TODO (90): Set the velocity variable equal to negative velocity
     *      
     *      TODO (91): Set the rotation of the ball to the negative equivalent of the current rotation ( -getRotation() )
     *      
     *      TODO (92): Move the ball at the current velocity
     *      
     * TODO (93): If the y location of the Ball is less than or equal to 10...
     * 
     *      TODO (94): Set the rotation of the ball to the negative equivalent of the current rotation
     *      
     * TODO (95): If the y location of the Ball is greater than or equal to 590...
     * 
     *      TODO (96): Set the rotation of the ball to the negative equivalent of the current rotation
     *      
     * TODO (97): If the x location of the Ball is less than or equal to 10...
     * 
     *      TODO (98): Remove this object from the world
     *      
     *      TODO (99): Initialize the getPoint variable to (Score)world.getObjects(Score.class).get(1) (this will get player two's scoreboard)
     *      
     *      TODO (100): Increase the score of the scoreboard that will be getting a point by using the countScore method of getPoint
     *      
     *      TODO (101): Reset the world by using the reset method of world
     *      
     * TODO (102): Otherwise, if the x location of the Ball is greater than or equal to 790...
     * 
     *      TODO (103): Remove this object from the world
     *      
     *      TODO (104): Initialize the getPoint variable to (Score)world.getObjects(Score.class).get(0) (this will get player one's scoreboard)
     *      
     *      TODO (105): Increase the score of the scoreboard that will be getting a point by using the countScore method of getPoint
     *      
     *      TODO (106): Reset the world by using the reset method of world
     */
    private void checkCollision()
    {
        Actor hitting = getOneIntersectingObject(Paddle.class);
        PlayField world = (PlayField)getWorld();
        Score getPoint;
        if (hitting != null)
        {
            velocity = -velocity;
            setRotation( -getRotation() );
            move(velocity);

        }
        if ( getY() <= 10 )
        {
            setRotation( -getRotation() );

        }
        if ( getY() >= 590 )
        {
            setRotation( -getRotation() );
        }
        if ( getX() <= 10 )
        {
            getWorld().removeObject( this );
            getPoint = (Score)world.getObjects(Score.class).get(1);
            getPoint.countScore();
            world.reset();
        }
        else if (getX() >= 790 )
        {
            getWorld().removeObject( this );
            getPoint = (Score)world.getObjects(Score.class).get(0);
            getPoint.countScore();
            world.reset();
        }
    }


    /**
     * setVelocity allows the velocity to be set to a particular speed in
     * other points throughout this code.
     * 
     * @param There is a parameter called v that represents the number 
     * for the velocity
     * @return Nothing is returned
     * 
     * TODO (52): Declare a public method called setVelocity that does not
     *            return anything and has an integer parameter called v
     *          
     * TODO (53): Inside the method, set velocity variable to the v parameter
     */
    public void setVelocity( int v )
    {
        velocity = v;
    }

}
