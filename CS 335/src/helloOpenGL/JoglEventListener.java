package helloOpenGL;






import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.nio.DoubleBuffer;

import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;




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
	float rot;
	
	boolean user_rotate = false;
	boolean user_zoom = false;
	boolean move_planets = true;
	boolean angled_view = true;
	double view_angle = Math.PI/4.0;
	float model_angle = 0;
	
	double day = 0;
	double year = 0;
	double lunar_cycle = 0;
	double Zoom = 1;
	
	/*
	 * Custom variables for mouse drag operations 
	 */
	int windowWidth, windowHeight;
	float orthoX=40;
	float tVal_x, tVal_y, rVal_x, rVal_y, rVal;
	double rtMat[] = new double[16];
	
	//Variables for rotating and zooming the camera
	double mouseX0, mouseY0;
	double centerX = 0;
	double centerY = 0;
	double eyeX = Math.cos(Math.PI/4.0);
	double eyeY = 1;
	double eyeZ = Math.sin(Math.PI/4.0);
	int saveRTnow=0, mouseDragButton=0;
	

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
	        gl.glClearDepth(1.0f);                      // Depth Buffer Setup
	        gl.glEnable(GL.GL_DEPTH_TEST);              // Enables Depth Testing
	        gl.glDepthFunc(GL.GL_LEQUAL);               // The Type Of Depth Testing To Do
	        // Really Nice Perspective Calculations
	        //gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);

	        gl.glMatrixMode(GL2.GL_MODELVIEW);
	        gl.glLoadIdentity();
	        gl.glGetDoublev(GL2.GL_MODELVIEW_MATRIX, rtMat, 0);
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
	        gl.glOrtho(-orthoX*0.5, orthoX*0.5, -orthoX*0.5*height/width, orthoX*0.5*height/width, -100, 100);
	        //glu.gluPerspective(45.0f, h, 1.0, 200.0);
	        
	        if(angled_view){
	        	glu.gluLookAt(Math.cos(Math.PI/4.0), 1, Math.sin(Math.PI/4.0), 0, 0, 0, 0, 1, 0);        
	        }
	    }

	    //THIS FUNCTION DRAWS A WIREFRAME SPHERE WITH THE GIVEN SPHERICAL COORDINATES    
	    public void drawWireFrameSphere(final GL2 gl){
	    	
	    	double Sphere_x; double Sphere_y; double Sphere_z;
			double rho = 1.0;			//distance from the origin
			double theta;		//angle from the positive x-axis
			double phi;			//angle away from the z-axis toward the y-axis  
			//double X_offset; double Y_offset; double Z_offset;	
	    	
	    	//Latitude lines
			for(int j = -240; j < 270; j = j + 30){
				gl.glPushMatrix();
				//gl.glLoadIdentity();
				gl.glRotated(90, 1, 0, 0);
				phi = j/180.0 * Math.PI;
				gl.glBegin(GL2.GL_LINE_STRIP);
				gl.glColor3f(1, 1, 1);
				for(int i = 0; i < 360; i++){
					theta = i/180.0 * Math.PI;
					Sphere_x = rho * Math.sin(phi) * Math.cos(theta);
					Sphere_y = rho * Math.sin(phi) * Math.sin(theta);
					Sphere_z = rho * Math.cos(phi);
					gl.glVertex3d(Sphere_x, Sphere_y, Sphere_z);
				}
				gl.glEnd();
				gl.glPopMatrix();
			}
			//Longitude lines
			for(int j = 90; j < 270; j = j + 30){
				gl.glPushMatrix();
				//gl.glLoadIdentity();
				gl.glRotated(90, 1, 0, 0);
				theta = j/180.0 * Math.PI;
				gl.glBegin(GL2.GL_LINE_STRIP);
				gl.glColor3f(1, 1, 1);
				for(int i = 0; i < 360; i++){
					phi = i/180.0 * Math.PI;
					Sphere_x = rho * Math.sin(phi) * Math.cos(theta);
					Sphere_y = rho * Math.sin(phi) * Math.sin(theta);
					Sphere_z = rho * Math.cos(phi);
					gl.glVertex3d(Sphere_x, Sphere_y, Sphere_z);
				}
				gl.glEnd();
				gl.glPopMatrix();
			}
	    }
	    
	    
		@Override
		public void display(GLAutoDrawable gLDrawable) {
			// TODO Auto-generated method stub
			final GL2 gl = gLDrawable.getGL().getGL2();

			gl.glClearColor(0, 0, 0, 1);
			gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

			//backrgb[0]+=0.0005;
			//if (backrgb[0]> 1) backrgb[0] = 0; 

			
			
			gl.glMatrixMode(GL2.GL_PROJECTION);
			gl.glLoadIdentity();
			gl.glOrtho(-orthoX*0.5, orthoX*0.5, -orthoX*0.5*windowHeight/windowWidth, orthoX*0.5*windowHeight/windowWidth, -100, 100);
			glu.gluLookAt(eyeX, eyeY, eyeZ, centerX, centerY, 0, 0, 1, 0);
			
			
			//glu.gluPerspective(45.0f, windowWidth/windowHeight, 1.0, 200.0);
			
			if(move_planets){
				day = (day + 0.3) % 360;
				year = (year + 0.3) % 360;
				lunar_cycle = (lunar_cycle + 2.8) % 360;
				
			}

			gl.glMatrixMode(GL2.GL_MODELVIEW);
			
			//THE SUN
			gl.glPushMatrix();
			gl.glRotated(day, 0, 1, 0);
			gl.glScaled(Zoom, Zoom, Zoom);
			drawWireFrameSphere(gl);
			gl.glPopMatrix();
			
			//Rotate everything about the y-axis (the Sun's center)
			//gl.glRotated(0.5f, 0, 1, 0);
			
			
			//THE EARTH
			gl.glPushMatrix();
			gl.glRotated(year, 5*Math.sin(12.0/180.0*Math.PI), 5*Math.cos(12.0/180.0*Math.PI), 0);
			gl.glTranslated(-5.0 * Zoom, 1 * Zoom, 0);
			gl.glScaled(1.0/3.0, 1.0/3.0, 1.0/3.0);
			gl.glScaled(Zoom, Zoom, Zoom);
			drawWireFrameSphere(gl);
			gl.glPopMatrix();
			
			//THE MOON
			gl.glPushMatrix();
			gl.glRotated(year, 5*Math.sin(12.0/180.0*Math.PI), 5*Math.cos(12.0/180.0*Math.PI), 0);
			gl.glTranslated(-5.0 * Zoom, 1 * Zoom, 0);
			//gl.glRotated(day, 0, 1, 0);
			gl.glRotated(lunar_cycle, Math.sin(12.0/180.0*Math.PI), -Math.cos(12.0/180.0*Math.PI), 0);
			gl.glTranslated(0.0, 0.0, 1 * Zoom);
			gl.glScaled(1.0/9.0, 1.0/9.0, 1.0/9.0);
			gl.glScaled(Zoom, Zoom, Zoom);
			drawWireFrameSphere(gl);
			gl.glPopMatrix();
			
			
			
			//Orbit of the Moon: a blue circle tilted 12 degrees
			//SPHERICAL COORDINATES
			double Sphere_x = 0;	double Sphere_y = 0;	double Sphere_z = 0;
			double rho = 1.0;
			double theta = 12.0/180.0 * Math.PI;			//angle from the positive x-axis
			double phi = 0;		//angle away from the z-axis toward the y-axis  
			double X_offset = 0;	double Y_offset = 0;	double Z_offset = 0;
			
			gl.glPushMatrix();
			gl.glRotated(year, 5*Math.sin(12.0/180.0*Math.PI), 5*Math.cos(12.0/180.0*Math.PI), 0);
			//gl.glRotated(year, 0, 12, 1);
			gl.glTranslated(-5 * Zoom, 1 * Zoom, 0);
			gl.glScaled(Zoom, Zoom, Zoom);
			gl.glBegin(GL2.GL_LINE_STRIP);
			gl.glColor3d(0, 0, 1.0);
			for(int h = 0; h <= 360; h++){
				phi = h/180.0 * Math.PI;
				Sphere_x = rho * Math.sin(phi) * Math.cos(theta) + X_offset;
				Sphere_y = rho * Math.sin(phi) * Math.sin(theta) + Y_offset;
				Sphere_z = rho * Math.cos(phi) + Z_offset;
				gl.glVertex3d(Sphere_x, Sphere_y, Sphere_z);
			}
			gl.glEnd();
			gl.glPopMatrix();
			
			
			//Orbit of the Earth: a red circle
			//SPHERICAL COORDINATES
			Sphere_x = 0;	Sphere_y = 0;	Sphere_z = 0;
			rho = 5.0 * Zoom;
			theta = 0.0;			//angle from the positive x-axis
			phi = Math.PI/2.0;		//angle away from the z-axis toward the y-axis  
			
			X_offset = 0;	Y_offset = 0;	Z_offset = 0;
			
			gl.glPushMatrix();
			//gl.glRotated(year, 0, 12, 1);
			gl.glRotated(90, 1, 0, 0);
			gl.glRotated(-12, 0, 1, 0);
			gl.glScaled(Zoom, Zoom, Zoom);
			gl.glBegin(GL2.GL_LINE_STRIP);
			gl.glColor3d(1.0, 0, 0);
			for(int h = 0; h <= 360; h++){
				theta = h/180.0 * Math.PI;
				Sphere_x = rho * Math.sin(phi) * Math.cos(theta) + X_offset;
				Sphere_y = rho * Math.sin(phi) * Math.sin(theta) + Y_offset;
				Sphere_z = rho * Math.cos(phi) + Z_offset;
				gl.glVertex3d(Sphere_x, Sphere_y, Sphere_z);
			}
			gl.glEnd();
			gl.glPopMatrix();
			
			
			//CARTESIAN X, Y, and Z AXIS
			gl.glPushMatrix();
			gl.glLoadIdentity();
			//X-axis
			gl.glBegin(GL2.GL_LINE_STRIP);
			gl.glColor3d(1, 0, 0);
			gl.glVertex3d(10, 0, 0);
			gl.glVertex3d(-10, 0, 0);
			gl.glEnd();
			
			//Y-axis
			gl.glBegin(GL2.GL_LINE_STRIP);
			gl.glColor3d(0, 1, 0);
			gl.glVertex3d(0, 10, 0);
			gl.glVertex3d(0, -10, 0);
			gl.glEnd();
			
			//Z-axis
			gl.glBegin(GL2.GL_LINE_STRIP);
			gl.glColor3d(0, 0, 1);
			gl.glVertex3d(0, 0, 10);
			gl.glVertex3d(0, 0, -10);
			gl.glEnd();
			gl.glPopMatrix();
			
			
			
			
	        //THE UK SHAPE FROM HOMEWORK 2
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
	        gl.glEnd();                         // Finished Drawing The Triangle
	        */
		}

		@Override
		public void dispose(GLAutoDrawable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
		    char key= e.getKeyChar();
			System.out.printf("Key typed: %c\n", key); 
			
			if(key == 't'){
				move_planets = !move_planets;
			}
			if(key == '0'){
				angled_view = !angled_view;
			}
			if(key == 'r' || key == 'R'){
				Zoom = 1;
			}
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
			
			if(user_rotate){
				centerX = XX;
				centerY = YY;
			}
			if(user_zoom){
				System.out.printf("%f\n", mouseX0 - XX);
				if(Zoom > 0.1 && mouseX0 - XX > 0){
					Zoom = Zoom * (1 + (mouseX0 - XX));
				}
				else if(Zoom < 10.0 && mouseX0 - XX < 0){
					Zoom = Zoom * (1 + (mouseX0 - XX));
				}
				//Zoom = Zoom * (1 + (mouseX0 - XX)/100.0);	
			}	
			
			mouseX0 = XX;
			mouseY0 = YY;
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
			System.out.printf("Point clicked: (%.3f, %.3f)\n", XX, YY);
			
			centerX = XX;
			centerY = YY;
			//mouseX0 = e.getX();
			//mouseY0 = e.getY();
			mouseX0 = XX;
			mouseY0 = YY;
			if(e.getButton()==MouseEvent.BUTTON1) {	// Left button
				user_rotate = true;
			}
			else if(e.getButton()==MouseEvent.BUTTON3) {	// Right button
				user_zoom = true;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			user_rotate = false;
			user_zoom = false;
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



