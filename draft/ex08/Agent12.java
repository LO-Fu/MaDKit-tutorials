package communication.ex08;

import java.util.logging.Level;
import javax.swing.JFrame;
import madkit.kernel.Agent;
import madkit.kernel.Message;
import madkit.message.StringMessage;

/**
 * Shows how agents exchange messages.
 * 
 * 		 
 * 
 * 		#jws communication.ex08.Agent12 jws# 
 * 
 * 
 * 
 */

public class Agent12 extends Agent
{
	/* 
	 * Firstly, taking position in the artificial society (having a GroupA and a Role1).
	 */
	protected void activate() 
	{	
		getLogger().setLevel(Level.FINEST);

		createGroupIfAbsent("communication","GroupC");
		requestRole("communication","GroupC","ReplyRole");
	}
	
	/* 
	 * Now replying to Agent10
	 */
	protected void live()
	{
		Message incommingMessage = waitNextMessage();
		
		ReturnCode code = null;
		while(code != ReturnCode.SUCCESS)//Until we succeed sending the reply.
			{		
				code = sendReplyWithRole(incommingMessage,new StringMessage("Four"), "ReplyRole");
			}
		getLogger().info("I just sent the "+incommingMessage.toString());
		pause(3000);
	 	while(nextMessage() != null)
	 		pause(3000);
	}

	public void setupFrame(AgentFrame frame) 
	{
		super.setupFrame(frame);
		frame.setLocation(400,300);
	}	
}