package helloOpenGL;






import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.awt.image.DataBufferByte; 










import java.nio.ByteOrder;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.jogamp.opengl.util.awt.TextRenderer;





public class JoglEventListener implements GLEventListener, KeyListener, MouseListener, MouseMotionListener {
	
	float[] vertices={5.97994f, -0.085086f, -0.010798f, 
			5.97994f, 10.0043f, -0.010798f, 
			7.99077f, 10.0043f, -0.010798f, 
			7.99077f, 11.3449f, -0.010798f, 
			-0.405339f, 11.3449f, -0.010798f, 
			-0.405339f, 9.98083f, -0.010798f, 
			1.65252f, 9.98083f, -0.010798f, 
			1.65252f, 0.549879f, -0.010798f, 
			-0.722839f, 0.549879f, -0.010798f, 
			-0.722839f, -1.69612f, -0.010798f, 
			2.6168f, -1.69612f, -0.010798f, 
			-7.24925f, 0.42055f, -0.010798f, 
			-9.35415f, 0.42055f, -0.010798f, 
			-9.35415f, 10.0043f, -0.010798f, 
			-7.37859f, 10.0043f, -0.010798f, 
			-7.37859f, 11.3802f, -0.010798f, 
			-15.8217f, 11.3802f, -0.010798f, 
			-15.8217f, 9.99258f, -0.010798f, 
			-13.8109f, 9.99258f, -0.010798f, 
			-13.8109f, -0.061591f, -0.010798f, 
			-10.2361f, -1.73139f, -0.010798f, 
			-7.26099f, -1.73139f, -0.010798f, 
			-6.1909f, 0.855631f, -0.010798f, 
			-8.11942f, 0.855631f, -0.010798f, 
			-8.11942f, 2.31379f, -0.010798f, 
			0.217914f, 2.31379f, -0.010798f, 
			0.217914f, 0.926204f, -0.010798f, 
			-1.73415f, 0.926204f, -0.010798f, 
			-1.73415f, -4.10675f, -0.010798f, 
			9.23724f, 0.937952f, -0.010798f, 
			7.26169f, 0.937952f, -0.010798f, 
			7.26169f, 2.38434f, -0.010798f, 
			15.6696f, 2.38434f, -0.010798f, 
			15.6696f, 1.00851f, -0.010798f, 
			14.964f, 1.00851f, -0.010798f, 
			7.75558f, -2.44873f, -0.010798f, 
			14.4231f, -9.36318f, -0.010798f, 
			16.0576f, -9.36318f, -0.010798f, 
			16.0576f, -10.6685f, -0.010798f, 
			7.62625f, -10.6685f, -0.010798f, 
			7.62625f, -9.33965f, -0.010798f, 
			9.67236f, -9.33965f, -0.010798f, 
			4.49827f, -3.90687f, -0.010798f, 
			-1.35784f, -6.59973f, -0.010798f, 
			-1.35784f, -9.3279f, -0.010798f, 
			0.217914f, -9.3279f, -0.010798f, 
			0.217914f, -10.6919f, -0.010798f, 
			-8.22526f, -10.6919f, -0.010798f, 
			-8.22526f, -9.32786f, -0.010798f, 
			-6.20266f, -9.32786f, -0.010798f};
	int[] indices={3, 2, 3, 1, 
			3, 1, 3, 6, 
			3, 1, 6, 10, 
			3, 10, 6, 7, 
			3, 10, 7, 8, 
			3, 4, 5, 6, 
			3, 4, 6, 3, 
			3, 10, 8, 9, 
			3, 1, 10, 0, 
			3, 13, 14, 15, 
			3, 13, 15, 18, 
			3, 13, 18, 20, 
			3, 13, 20, 12, 
			3, 16, 17, 18, 
			3, 16, 18, 15, 
			3, 12, 20, 21, 
			3, 12, 21, 11, 
			3, 20, 18, 19, 
			3, 49, 22, 44, 
			3, 44, 22, 28, 
			3, 44, 28, 43, 
			3, 43, 28, 29, 
			3, 43, 29, 42, 
			3, 42, 29, 35, 
			3, 42, 35, 41, 
			3, 41, 35, 36, 
			3, 41, 36, 38, 
			3, 38, 36, 37, 
			3, 39, 40, 41, 
			3, 39, 41, 38, 
			3, 29, 30, 32, 
			3, 29, 32, 34, 
			3, 29, 34, 35, 
			3, 46, 47, 49, 
			3, 46, 49, 44, 
			3, 46, 44, 45, 
			3, 22, 23, 25, 
			3, 22, 25, 27, 
			3, 22, 27, 28, 
			3, 25, 23, 24, 
			3, 27, 25, 26, 
			3, 49, 47, 48, 
			3, 32, 30, 31, 
			3, 34, 32, 33};
	float backrgb[] = new float[4]; 
	boolean bRotate = false;
	boolean bTranslate = false;
	boolean bLight1On = true;
	boolean bLight2On = true;
	boolean bLight3On = true;
	boolean bFirstPerson = false;
	float rot; 
	float rotX; 
	
	float halfCourtWidth = 5.0f;
	float halfCourtLength = 8.4f;
	
	//Variables for moving the ball around
	boolean ballMoving = false;
	double iBall_x, iBall_z, BallX, BallZ = 0;
	double iBall_y = 0.8;
	double BallY = 0.8;
	
	double tBall_x, tBall_y, tBall_z = 0;
	//double initialVX, initialVY, initialVZ = 0;
	float gravity = -3.2178f;			//acceleration due to gravity is 32.178 ft/sec^2
	long initSysTime = System.currentTimeMillis();
	double dTimeX = 0;
	double dTimeY = 0;
	double[] initialVector = {0.1, -0.1, 0};
	double ballSpeed = 0.4;
	double theta = Math.atan2(0.1, -0.1);
	//double[] initialVelocity = {ballSpeed * Math.cos(theta), ballSpeed * Math.sin(theta)};
	double initialVX = (Math.cos(theta)) * ballSpeed;
	double initialVY = (Math.sin(theta)) * ballSpeed;
	/*
	 * Custom variables for mouse drag operations 
	 */
	boolean bZoom = false;
	double Zoom = 10;
	
	int windowWidth, windowHeight;
	float orthoX=40;
	float tVal_x, tVal_y, rVal_x, rVal_y, rVal = 0;
	double rtMat[] = new double[16];
	int mouseX0, mouseY0;
	int saveRTnow=0, mouseDragButton=0;
	GLUquadric earth;
	int texID[]  = new int[3]; 
    
	 float[] lightPos = { 10,10,10,1 };        // light position
	 float[] lightPos1 = { 0, 10, 0, 1};				//Light 1 is positioned straight up
	 float[] lightPos2 = {-halfCourtLength, 1, 0, 1};	//Light 2 is over the left baseboard
	 float[] lightPos3 = {halfCourtLength, 1, 0, 1};	//Light 3 is over the right baseboard

    	private GLU glu = new GLU();

	
	 public void displayChanged(GLAutoDrawable gLDrawable, 
	            boolean modeChanged, boolean deviceChanged) {
	    }

	    /** Called by the drawable immediately after the OpenGL context is
	     * initialized for the first time. Can be used to perform one-time OpenGL
	     * initialization such as setup of lights and display lists.
	     * @param gLDrawable The GLAutoDrawable object.
	     */
	    public void init(GLAutoDrawable gLDrawable) {
	        GL2 gl = gLDrawable.getGL().getGL2();
	        //gl.glShadeModel(GL.GL_LINE_SMOOTH);              // Enable Smooth Shading
	        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);    // Black Background
	        //gl.glClearDepth(1.0f);                      // Depth Buffer Setup
	        gl.glEnable(GL.GL_DEPTH_TEST);              // Enables Depth Testing
	        //gl.glDepthFunc(GL.GL_LEQUAL);               // The Type Of Depth Testing To Do
	        // Really Nice Perspective Calculations
	        //gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

	        earth = glu.gluNewQuadric();
	        
	        gl.glMatrixMode(GL2.GL_MODELVIEW);
	        gl.glLoadIdentity();
	        gl.glGetDoublev(GL2.GL_MODELVIEW_MATRIX, rtMat, 0);
	        
	        
	       
	        float[] noAmbient = { 0.2f, 0.2f, 0.2f, 1f };   // low ambient light
	        float[] diffuse = { 1.0f, 1.0f, 1.0f, 1f };     // full diffuse color
	        float[] diffuse1 = { 1.0f, 0.0f, 0.0f, 0.0f };	// red diffuse color
	        //gl.glEnable(GL2.GL_LIGHTING);
	        //gl.glEnable(GL2.GL_LIGHT0);
	        //gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, noAmbient, 0);
	        //gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
	        //gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION,lightPos, 0);
	        
	        gl.glEnable(GL2.GL_LIGHTING);
	        //gl.glEnable(GL2.GL_LIGHT1);
	        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_AMBIENT, noAmbient, 0);
	        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_SPECULAR, diffuse, 0);
	        gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos1, 0);
	        
	        //gl.glEnable(GL2.GL_RESCALE_NORMAL );

	        //gl.glEnable(GL2.GL_LIGHTING);
	        //gl.glEnable(GL2.GL_LIGHT2);
	        float[] noAmbient2 = { 1.0f, 0.0f, 0.0f, 1.0f};
	        float[] diffuse2 = { 1.0f, 0.0f, 0.0f, 1.0f };
	        gl.glLightfv(GL2.GL_LIGHT2, GL2.GL_AMBIENT, noAmbient2, 0);
	        gl.glLightfv(GL2.GL_LIGHT2, GL2.GL_SPECULAR, diffuse2, 0);
	        gl.glLightfv(GL2.GL_LIGHT2, GL2.GL_POSITION, lightPos2, 0);
	        
	        //gl.glEnable(GL2.GL_RESCALE_NORMAL );
	        
	        //gl.glEnable(GL2.GL_LIGHTING);
	        //gl.glEnable(GL2.GL_LIGHT3);
	        gl.glLightfv(GL2.GL_LIGHT3, GL2.GL_AMBIENT, noAmbient, 0);
	        gl.glLightfv(GL2.GL_LIGHT3, GL2.GL_SPECULAR, diffuse, 0);
	        gl.glLightfv(GL2.GL_LIGHT3, GL2.GL_POSITION, lightPos3, 0);
	        
	        gl.glEnable(GL2.GL_RESCALE_NORMAL );
	        
	        // load an image; 
	        try {
	        	//The UK Logo
				//BufferedImage aImage = ImageIO.read(new File("C:\\Users\\Bryan\\eclipse_workspace\\UKY.jpg"));
				//URL url = new URL("http:\\")
				//ByteBuffer buf = convertImageData(aImage);
				
				gl.glGenTextures(3, texID, 0);
				//gl.glBindTexture(GL.GL_TEXTURE_2D, texID[0]);
				
				//The basketball court
				BufferedImage aImage2 = ImageIO.read(new File("C:\\Users\\Bryan\\eclipse_workspace\\ruppoverheadwall3.jpg"));
				ByteBuffer buf2 = convertImageData(aImage2);
				//gl.glGenTextures(3, texID, 0);
				gl.glBindTexture(GL.GL_TEXTURE_2D, texID[1]);
				
				gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
		        gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);

				gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGB, aImage2.getWidth(), 
	                    aImage2.getHeight(), 0, GL2.GL_BGR, GL.GL_UNSIGNED_BYTE, buf2);
				
				
				//The basketball texture
				BufferedImage aImage3 = ImageIO.read(new File("C:\\Users\\Bryan\\eclipse_workspace\\Basketball2.jpg"));
				ByteBuffer buf3 = convertImageData(aImage3);
				gl.glBindTexture(GL.GL_TEXTURE_2D, texID[2]);
				
				gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
		        gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
				
				gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGB, aImage3.getWidth(), 
	                    aImage3.getHeight(), 0, GL2.GL_BGR, GL.GL_UNSIGNED_BYTE, buf3);
				
				gl.glEnable(GL.GL_TEXTURE_2D);
				
				gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE);
				//gl.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_REPLACE);
				
			} catch (IOException e) {
				// 
				e.printStackTrace();
			} 
	    }


	    
	    private ByteBuffer convertImageData(BufferedImage bufferedImage) {
	        ByteBuffer imageBuffer;
	        //WritableRaster raster;
	        //BufferedImage texImage;

	        /*
	        ColorModel glAlphaColorModel = new ComponentColorModel(ColorSpace
	                .getInstance(ColorSpace.CS_sRGB), new int[] { 8, 8, 8, 8 },
	                true, false, Transparency.TRANSLUCENT, DataBuffer.TYPE_BYTE);

	        raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,
	                bufferedImage.getWidth(), bufferedImage.getHeight(), 4, null);
	        texImage = new BufferedImage(glAlphaColorModel, raster, true,
	                new Hashtable());

	        // copy the source image into the produced image
	        Graphics g = texImage.getGraphics();
	        g.setColor(new Color(0f, 0f, 0f, 0f));
	        g.fillRect(0, 0, 256, 256);
	        g.drawImage(bufferedImage, 0, 0, null);
*/
	        // build a byte buffer from the temporary image
	        // that be used by OpenGL to produce a texture.
	        
	        DataBuffer buf = bufferedImage.getRaster().getDataBuffer(); 
	      
	        
	        final byte[] data = ((DataBufferByte) buf).getData();

	        //byte[] data = ((DataBufferByte) texImage.getRaster().getDataBuffer())
	          //      .getData();

	        //System.out.printf("%d %d, %d\n", bufferedImage.getWidth(), bufferedImage.getHeight(), data.length); 
	        //imageBuffer = ByteBuffer.allocateDirect(data.length);
	        //imageBuffer.order(ByteOrder.nativeOrder());
	        //imageBuffer.put(data, 0, data.length);
	        //imageBuffer.flip();

	        //return imageBuffer;
	        
	        return (ByteBuffer.wrap(data)); 
	    }
	    
	    
	    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, 
	            int height) {
	    	windowWidth = width;
	    	windowHeight = height;
	        final GL2 gl = gLDrawable.getGL().getGL2();

	        if (height <= 0) // avoid a divide by zero error!
	            height = 1;
	        final float h = (float) width / (float) height;
	        gl.glViewport(0, 0, width, height);
	        gl.glMatrixMode(GL2.GL_PROJECTION);
	        gl.glLoadIdentity();
	        //gl.glOrtho(-orthoX*0.5, orthoX*0.5, -orthoX*0.5*height/width, orthoX*0.5*height/width, -100, 100);
	        glu.gluPerspective(45.0f, h, 1.0, 200.0);
	        //glu.gluLookAt(0, 1, 5, 0, 0, 0, 0, 1, 0);
	        
	        gl.glMatrixMode(GL2.GL_MODELVIEW);
	        gl.glLoadIdentity();
	        //glu.gluLookAt(0, 0, 6, 0, 0, 0, 0, 1, 0);
	    }

	    public void drawCourtFloor(final GL2 gl){
	    	
	    	gl.glBegin(GL2.GL_QUADS);
	         gl.glTexCoord2f(0.0f, 0.0f);
	         gl.glVertex3f(-halfCourtLength, 0.0f, -halfCourtWidth);
	         
	         gl.glTexCoord2f(1.0f, 0.0f);
	         gl.glVertex3f(halfCourtLength, 0.0f, -halfCourtWidth);
	         
	         gl.glTexCoord2f(1.0f, 1.0f);
	         gl.glVertex3f(halfCourtLength, 0.0f, halfCourtWidth);
	         
	         gl.glTexCoord2f(0.0f, 1.0f);
	         gl.glVertex3f(-halfCourtLength, 0.0f, halfCourtWidth);
	         
	         gl.glEnd();
	         
	         //glu.gluSphere(earth, 3, 0, 0);
	         
	         //Drawing a surrounding floor boundary around the court
	         gl.glBegin(GL2.GL_QUADS);
	         gl.glVertex3f(-1.5f * halfCourtLength, 0.0f, -1.5f * halfCourtWidth);
	         gl.glVertex3f(1.5f * halfCourtLength, 0, -1.5f * halfCourtWidth);
	         gl.glVertex3f(1.5f * halfCourtLength, 0, -halfCourtWidth);
	         gl.glVertex3f(-1.5f * halfCourtLength, 0, -halfCourtWidth);
	         gl.glEnd();
	         
	         gl.glBegin(GL2.GL_QUADS);
	         gl.glVertex3f(-1.5f * halfCourtLength, 0.0f, -halfCourtWidth);
	         gl.glVertex3f(-halfCourtLength, 0, -halfCourtWidth);
	         gl.glVertex3f(-halfCourtLength, 0, 1.5f * halfCourtWidth);
	         gl.glVertex3f(-1.5f * halfCourtLength, 0, 1.5f * halfCourtWidth);
	         gl.glEnd();
	         
	         gl.glBegin(GL2.GL_QUADS);
	         gl.glVertex3f(-halfCourtLength, 0.0f, halfCourtWidth);
	         gl.glVertex3f(halfCourtLength, 0, halfCourtWidth);
	         gl.glVertex3f(halfCourtLength, 0, 1.5f * halfCourtWidth);
	         gl.glVertex3f(-halfCourtLength, 0, 1.5f * halfCourtWidth);
	         gl.glEnd();
	         
	         gl.glBegin(GL2.GL_QUADS);
	         gl.glVertex3f(halfCourtLength, 0.0f, -halfCourtWidth);
	         gl.glVertex3f(1.5f * halfCourtLength, 0, -halfCourtWidth);
	         gl.glVertex3f(1.5f * halfCourtLength, 0, 1.5f * halfCourtWidth);
	         gl.glVertex3f(halfCourtLength, 0, 1.5f * halfCourtWidth);
	         gl.glEnd();

	    }
	    
	    public void drawCube(final GL2 gl) {
	    	gl.glBegin(GL2.GL_QUADS);
	         
	    	// on the XY plane
	    	// front plane
	         gl.glNormal3f(0,  0, 1);
	         gl.glColor3f(1, 0, 0);
	         
	         gl.glTexCoord2f(0.0f, 1.0f);
	         gl.glVertex3f(0, 0, 1); 
	        
	         
	         
	         gl.glTexCoord2f(1.0f, 1.0f);
	         gl.glVertex3f(1, 0, 1);
	         
	         gl.glTexCoord2f(1.0f, 0.0f);
	         gl.glVertex3f(1, 1, 1); 
	         
	         gl.glTexCoord2f(0.0f, 0.0f);
	         gl.glVertex3f(0, 1, 1);
	        
	         gl.glTexCoord2f(98.0f/255, 136.0f/255);
	         // back plane
	         gl.glNormal3f(0,  0, -1);
	         gl.glColor3f(1, 0, 0);
	         gl.glVertex3f(0, 0, 0); 
	         gl.glVertex3f(1, 0, 0);
	         gl.glVertex3f(1, 1, 0); 
	         gl.glVertex3f(0, 1, 0);
	         
	         // on the YZ plane
	         // left plane 
	         gl.glNormal3f(-1,  0, 0);
	         gl.glColor3f(0, 1, 0);
	         gl.glVertex3f(0, 0, 0); 
	         gl.glVertex3f(0, 1, 0);
	         gl.glVertex3f(0, 1, 1); 
	         gl.glVertex3f(0, 0, 1);
	         
	         // right plane
	         gl.glNormal3f(1,  0, 0);
	         gl.glColor3f(0, 1, 0);
	         gl.glVertex3f(1, 0, 0); 
	         gl.glVertex3f(1, 1, 0);
	         gl.glVertex3f(1, 1, 1); 
	         gl.glVertex3f(1, 0, 1);
	         
	         
	         // on the XZ plane,  
	         // up plane; 
	         gl.glNormal3f(0,  1, 0);
	         gl.glColor3f(0, 0, 1);
	         gl.glTexCoord2f(0+0.2f, 1-(1-0.2f));gl.glVertex3f(0, 1, 0); 
	         gl.glTexCoord2f(1-0.2f, 1-(1-0.2f));gl.glVertex3f(1, 1, 0);
	         gl.glTexCoord2f(1-0.2f, 1-(0 + 0.2f));gl.glVertex3f(1, 1, 1); 
	         gl.glTexCoord2f(0+0.2f, 1-(0 + 0.2f));gl.glVertex3f(0, 1, 1);
	         
	         // down plane; 
	         gl.glNormal3f(0,  -1, 0);
	         gl.glColor3f(0, 0, 1);
	         gl.glVertex3f(0, 0, 0); 
	         gl.glVertex3f(1, 0, 0);
	         gl.glVertex3f(1, 0, 1); 
	         gl.glVertex3f(0, 0, 1);
	        
	         gl.glEnd(); 
	    }
		@Override
		public void display(GLAutoDrawable gLDrawable) {
			// TODO Auto-generated method stub
			final GL2 gl = gLDrawable.getGL().getGL2();

			//gl.glClearColor(backrgb[0], 0, 1, 1);
			gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
			gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

			//backrgb[0]+=0.0005;
			//if (backrgb[0]> 1) backrgb[0] = 0; 

			
	         //glu.gluQuadricDrawStyle(earth, GLU.GLU_LINE);

	         
	         //glu.gluDeleteQuadric(earth);
			
			//THE CAMERA
			gl.glMatrixMode(GL2.GL_MODELVIEW);
	        gl.glLoadIdentity();
	        
	        gl.glEnable(GL2.GL_LIGHTING);
	        if (bLight1On){
	        	gl.glEnable(GL2.GL_LIGHT1);
	        }
	        else{
	        	gl.glDisable(GL2.GL_LIGHT1);
	        }
	        if (bLight2On){
	        	gl.glEnable(GL2.GL_LIGHT2);
	        }
	        else{
	        	gl.glDisable(GL2.GL_LIGHT2);
	        }
	        if (bLight3On){
	        	gl.glEnable(GL2.GL_LIGHT3);
	        }
	        else{
	        	gl.glDisable(GL2.GL_LIGHT3);
	        }
	        
	        //Zooming in and out
	        if(!bFirstPerson){
	        	glu.gluLookAt(0, 0, Zoom, 0, 0, 0, 0, 1, 0); 
	        }
	        else{
	        	glu.gluLookAt( BallX, BallY, BallZ,
    					BallX - initialVX, BallY - initialVY, BallZ,
    					0, 1, 0);
	        }
	         gl.glPushMatrix();
	         
	         //Rotate the scene according to previous user inputs
	         gl.glRotatef(rot, 0, 1, 0);
	       
	         gl.glRotatef(rotX, 1, 0, 0);
	         
	         //Translate the whole scene accorDing to previous user inputs
	         gl.glTranslatef(tVal_x, tVal_y, 0);
	         
	         //gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION,lightPos, 0);
	         gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos1, 0);
	         gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos2, 0);
	         gl.glLightfv(GL2.GL_LIGHT1, GL2.GL_POSITION, lightPos3, 0);
	         gl.glPushMatrix(); 
	         gl.glTranslatef(-0.5f, -0.5f, -0.5f); 
	         
	       //The color of the sphere
	         float materialColor[] = {1.0f, 1.0f, 0.0f, 1.0f};
	         //The specular (shiny) component of the material
	         float  materialSpecular[] = {0,0,1,1};
	         //The color emitted by the material
	         float materialEmission[] = {1.0f,1.0f,0, 1.0f};

	         float shininess = 20;

	         //gl.glEnable(GL2.GL_COLOR_MATERIAL);
	         gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_AMBIENT_AND_DIFFUSE, materialColor, 0);
	         gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, materialSpecular, 0);
	         //gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, materialEmission, 0);
	         gl.glMaterialf(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, shininess); 
		     
	         double theta = Math.atan2(initialVector[1], initialVector[0]);
	         if(BallX > 1.5 * halfCourtLength || BallX < 1.5 * -halfCourtLength){
	        	 ballMoving = false;
	         }
	         if(BallY > 50){
	        	 ballMoving = false;
	         }
	         if(BallZ > 1.5 * halfCourtWidth || BallZ < 1.5 * -halfCourtWidth){
	        	 ballMoving = false;
	         }
	         if(ballMoving){    
		         //POSITIONING THE BASKETBALL
		         
	        	 
	        	 //long temptime = System.currentTimeMillis();
		         if(BallY < 0.025){
		        	 initialVY = -(initialVY + gravity * dTimeY);
		        	 //iBall_x = initialVX * dTimeX;
		        	 iBall_y = 0.025;
		        	 //iBall_z = 0;
		        	 dTimeY = 0;
		         }
		         
		         // v_final = v_initial + a*t
		         dTimeX += 0.0015;
		         dTimeY += 0.0015;
		         //Current position for the basketball
		         //r_final = r_initial + v_initial*t + 1/2*a*t^2
		         BallX = iBall_x + initialVX * (dTimeX);
		         BallY = iBall_y + initialVY * (dTimeY) + 0.5 * gravity * Math.pow(dTimeY, 2);
		         BallZ = iBall_z; // + initialVector[2] * (dTime);
		         tBall_x = BallX - iBall_x;
		         tBall_y = BallY - iBall_y;
		         tBall_z = BallZ - iBall_z;
			}
	         
	         //DRAWING THE BASKETBALL
	         gl.glPushMatrix();
	         
	         if(!bFirstPerson){
		         gl.glTranslated(tBall_x, tBall_y, tBall_z);	//Translating the basketball again
		         gl.glTranslated(iBall_x, iBall_y, iBall_z);	//The starting location of the basketball
		         //drawCube(gl);
		         glu.gluQuadricDrawStyle(earth, GLU.GLU_FILL);
		         glu.gluQuadricNormals(earth, GLU.GLU_SMOOTH);
		         gl.glBindTexture(GL.GL_TEXTURE_2D, texID[2]);
		         glu.gluQuadricTexture(earth, true);
		         glu.gluSphere(earth, 0.075f, 24, 32);
		         
		         gl.glColor4d(0, 0, 0, 1);
		         gl.glBegin(GL2.GL_LINE_STRIP);
		         gl.glVertex3d(ballSpeed*Math.cos(theta), ballSpeed*Math.sin(theta), 0);
		         gl.glVertex3d(0 , 0, 0);
		         gl.glEnd();
	         //}
	         //else{
	        	 //gl.glMatrixMode(GL2.GL_PROJECTION);
	        	 //gl.glLoadIdentity();
	        	 //gl.glTranslated(tBall_x, tBall_y, tBall_z);
	        	 //gl.glTranslated(iBall_x,  iBall_y, iBall_z);
	        	 theta = Math.atan2(initialVector[1], initialVector[0]);
	        	 
	        	 //gl.glMatrixMode(GL2.GL_MODELVIEW);
	         }
	         gl.glPopMatrix();
	         
	         
	         //DRAW THE COURT FLOOR
	         gl.glBindTexture(GL.GL_TEXTURE_2D, texID[1]);
	         drawCourtFloor(gl);
	         
	         gl.glPopMatrix(); 
	         
	         materialColor[0]= 0; 
	         
	         gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_DIFFUSE, materialColor, 0);
	         gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_SPECULAR, materialSpecular, 0);
	         //gl.glMaterialfv(GL2.GL_FRONT_AND_BACK, GL2.GL_EMISSION, materialEmission, 0);
	         gl.glMaterialf(GL2.GL_FRONT_AND_BACK, GL2.GL_SHININESS, 100); 
	         
	         gl.glPushMatrix();
	         gl.glTranslatef(0, 2, 0);
	         gl.glColor3f(0.8f, 0.8f, 0.8f);
	         //mysphere(gl); 
	         gl.glPopMatrix();
	         
	         
	         
	         //gl.glTranslatef(2, 0, 0);
	         //gl.glTranslatef(-1f, -1.0f, -1.0f);
	         //gl.glTranslatef(0.5f, 0.5f, 0.5f);
	         //gl.glScalef(0.5f, 0.5f, 0.5f); 
	         //gl.glTranslatef(-0.5f, -0.5f, -0.5f);
	         //drawCube(gl); 
	         
	         
	         
	         //gl.glScalef(1.0f/2, 1, 1);
	         //gl.glTranslatef(0, -delta, 0);
	         
	         
	         int width = 100, height = 100; 
	         byte[] src = new byte[width*height];

	         for(int a=0; a<height; a++){
	        	 int color = (int)(a*1.0f/height*255); 
	             for(int b=0; b<width; b++){
	                 src[a*width+b]= (byte) color;
	             }
	         }

	         gl.glPixelStorei(GL2.GL_UNPACK_ALIGNMENT, 1);
	         gl.glPixelStorei(GL2.GL_UNPACK_SKIP_PIXELS, 0);
	         gl.glPixelStorei(GL2.GL_UNPACK_SKIP_ROWS, 0);

	         
	         
	         gl.glPushMatrix(); 
	         gl.glLoadIdentity(); 
	         
	         gl.glMatrixMode(GL2.GL_PROJECTION);
	         gl.glPushMatrix(); 
	         
	         gl.glLoadIdentity(); 
	         
	         glu.gluOrtho2D(0, windowWidth, 0, windowHeight);
	         
	         gl.glRasterPos2f(windowWidth/2, windowHeight/2); // 0.0f);
	         
	         
	         /*gl.glDrawPixels(width, height,
	                 GL2.GL_RED, GL.GL_UNSIGNED_BYTE,
	                 ByteBuffer.wrap(src));
	         */
	         gl.glPopMatrix(); 
	         
	         gl.glMatrixMode(GL2.GL_MODELVIEW);
	         gl.glPopMatrix();
	         
	         
	         gl.glPopMatrix();
	         
	         //gl.glRasterPos2i(0, 0);
	         //gl.glDrawPixels(width, height,
	         //        GL2.GL_BLUE, GL.GL_UNSIGNED_BYTE,
	          //       ByteBuffer.wrap(src));
	         
	         /*
	         String text = "Hello World";

	         TextRenderer renderer = new TextRenderer(new Font("Serif", Font.PLAIN, 12), true, true);
	         renderer.beginRendering(100, 100);

	         
	         gl.glPushMatrix();
	         //gl.glLoadIdentity();
	         //gl.glTranslatef(2.0f, 2.0f, 0.0f);
	         renderer.setColor(0.0f, 1.0f, 1.0f, 1);
	         renderer.draw(text, 0, 0);
	         renderer.flush();
	         gl.glPopMatrix();

	         renderer.endRendering();
	        */
	        /*
			gl.glBegin(GL.GL_TRIANGLES);        // Drawing Using Triangles
        	for(int i=0; i<44; i++) {
        		gl.glColor3f(0.7f, 0.7f, 0.7f);
        		gl.glVertex3f(vertices[(indices[i*4+1])*3],
        					  vertices[(indices[i*4+1])*3+1],
        					  vertices[(indices[i*4+1])*3+2]);
        		gl.glVertex3f(vertices[(indices[i*4+2])*3],
  					  		  vertices[(indices[i*4+2])*3+1],
  					  		  vertices[(indices[i*4+2])*3+2]);
        		gl.glVertex3f(vertices[(indices[i*4+3])*3],
  					  		  vertices[(indices[i*4+3])*3+1],
  					  		  vertices[(indices[i*4+3])*3+2]);
        	}
	        gl.glEnd();
	          */                       // Finished Drawing The Triangle
		}

		@Override
		public void dispose(GLAutoDrawable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		    char key= e.getKeyChar();
			//System.out.printf("Key typed: %c\n", key); 
			if (key == KeyEvent.VK_ESCAPE )
				System.exit(0);
			if (key == '0'){
				rot = 0;
				rotX = 0;
				tVal_x = 0;
				tVal_y = 0;
				Zoom = 10;
				
				ballMoving = false;
				iBall_x = 0;
				iBall_z = 0;
				BallX = 0;
				BallZ = 0;
				iBall_y = 0.8;
				BallY = 0.8;
				
				tBall_x = 0;
				tBall_y = 0;
				tBall_z = 0;
				//double initialVX, initialVY, initialVZ = 0;
				gravity = -3.2178f;			//acceleration due to gravity is 32.178 ft/sec^2
				initSysTime = System.currentTimeMillis();
				dTimeX = 0;
				dTimeY = 0;
				initialVector[0] = 0.1; initialVector[1] = -0.1; initialVector[2] = 0;
				ballSpeed = 0.4;
				theta = Math.atan2(0.1, -0.1);
				//double[] initialVelocity = {ballSpeed * Math.cos(theta), ballSpeed * Math.sin(theta)};
				initialVX = ballSpeed * Math.cos(theta);
				initialVY = ballSpeed * Math.sin(theta);
			}
			if (key == '1'){
				bLight1On = !bLight1On;
			}
			if (key == '2'){
				bLight2On = !bLight2On;
			}
			if (key == '3'){
				bLight3On = !bLight3On;
			}
			if (key == ' '){
				ballMoving = !ballMoving;
			}
			//Changing the initial velocity
			if (key == 'q' || key == 'Q'){
				initialVector[0] += 0.01;
			}
			if (key == 'a' || key == 'A'){
				initialVector[0] -= 0.01;
			}
			if (key == 'w' || key == 'W'){
				initialVector[1] += 0.01;
			}
			if (key == 's' || key == 'S'){
				initialVector[1] -= 0.01;
			}
			if (key == 'e' || key == 'E'){
				ballSpeed -= 0.01;
			}
			if (key == 'd' || key == 'D'){
				ballSpeed += 0.01;
			}
			if (key == 'p' || key == 'P'){
				bFirstPerson = !bFirstPerson;
			}
			theta = Math.atan(initialVector[1]/initialVector[0]);
			//theta = Math.atan2(initialVector[1], initialVector[0]);
			initialVX = (Math.cos(theta)) * ballSpeed;
			initialVY = (Math.sin(theta)) * ballSpeed;
			//initialVX = ballSpeed * initialVector[0];
			//initialVY = ballSpeed * initialVector[1];
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			
			float XX = (e.getX()-windowWidth*0.5f)*orthoX/windowWidth;
			float YY = -(e.getY()-windowHeight*0.5f)*orthoX/windowWidth;
			
			if(bRotate){
				rot += (e.getX()-mouseX0)*0.5;		
				rotX += (e.getY() - mouseY0)*0.5; 
			}
			if(bTranslate){
				tVal_x += (e.getX()-mouseX0)*0.05;
				tVal_y += (mouseY0 - e.getY())*0.05;
			}
			if(bZoom){
				if( (Zoom < 30 && Zoom + (e.getY()-mouseY0)*0.5 < 30)
						&& (Zoom > 0 && Zoom + (e.getY()-mouseY0)*0.5 > 0)){
					Zoom += (e.getY()-mouseY0)*0.5;
				}
				
			}
			mouseX0 = e.getX(); 
			mouseY0 = e.getY(); 
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			/*
			 * Coordinates printout
			 */
			float XX = (e.getX()-windowWidth*0.5f)*orthoX/windowWidth;
			float YY = -(e.getY()-windowHeight*0.5f)*orthoX/windowWidth;
			//System.out.printf("Point clicked: (%.3f, %.3f)\n", XX, YY);
			
			mouseX0 = e.getX();
			mouseY0 = e.getY();
			if(e.getButton()==MouseEvent.BUTTON1) {	// Left button
				bRotate = true;
			}
			else if(e.getButton()==MouseEvent.BUTTON3 && !e.isShiftDown()) {	// Right button
				bTranslate = true;
			}
			if(e.isShiftDown() && e.getButton()==MouseEvent.BUTTON3){
				bZoom = true;
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			bRotate = false;
			bTranslate = false;
			bZoom = false;
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		

	  /*  
	public void init(GLDrawable gLDrawable) {
		final GL gl = glDrawable.getGL();
        final GLU glu = glDrawable.getGLU();

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-1.0f, 1.0f, -1.0f, 1.0f); // drawing square
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }*/
	
}



