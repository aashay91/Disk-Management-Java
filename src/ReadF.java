import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;

import gnu.io.*;

import java.io.*;
import java.util.Enumeration;

import javax.swing.filechooser.FileSystemView;
public class ReadF {
	public static Set<String>pdlist=new HashSet<String>();
	public static File yourFile; 
	static BufferedWriter output; 
	static boolean cls=false;
	public static String nm;
	
	
	static{
		yourFile= new File("dump.txt");
		if(!yourFile.exists()) {
			try {
				yourFile.createNewFile();
				output= new BufferedWriter(new FileWriter(yourFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		else
		{
			try {
				FileWriter fileWritter = new FileWriter(yourFile.getName(),true);
				output = new BufferedWriter(fileWritter);
				fillpd();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
	
	public static void fillpd()
	{
		BufferedReader br=null;

		try {
			br=new BufferedReader(new FileReader(yourFile));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		String line="";
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(line!=null)
		{

			{
				String []l=line.split(":");

				if(!pdlist.contains(l[0]))
					pdlist.add(l[0]);



				try {
					line=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			


		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

		
		public static void  closewritter()
		{
			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cls=true;

		}
		public static HashSet<String>drives=new HashSet<String>();
		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			GRN f=new GRN();
			f.main1();
			String str="H:/algo/Final exam";
			//	show();
			//listf( str );
			//usb();


		}

		public static void fillDrives()
		{
			File[] f = File.listRoots();
			if(drives.size()!=0)
				drives.removeAll(drives);

			for (int i = 0; i < f.length; i++) {

				String drive = f[i].getPath();
				drives.add(drive);


			}
		}
		public static void show(String name)
		{


			nm=name;
			if(!pdlist.contains(nm))
				pdlist.add(nm);
			FileSystemView fsv = FileSystemView.getFileSystemView();
			File[] roots = File.listRoots();
			File fDrive;
			boolean flag=false;


			String driveLetter = "";


			File[] f = File.listRoots();
			fillDrives();
			for (int i = 0; i < f.length; i++) {

				String drive = f[i].getPath();
				drives.add(drive);
				String displayName = fsv.getSystemDisplayName(f[i]);
				String type = fsv.getSystemTypeDescription(f[i]);
				boolean isDrive = fsv.isDrive(f[i]);
				boolean isFloppy = fsv.isFloppyDrive(f[i]);
				boolean canRead = f[i].canRead();
				boolean canWrite = f[i].canWrite();
				System.out.println(drive);


			}
			while(true)
			{
				f = File.listRoots();
				for (int i = 0; i < f.length; i++) {
					String drive = f[i].getPath();
					if(!drives.contains(drive))
					{
						driveLetter=drive;
						System.out.println("Found"+driveLetter);
						flag=true;
						listf(drive);
						break;
					}
				}
				if(f.length<drives.size())
				{
					fillDrives();
				}
				if(flag)
					break;

			}

			closewritter();

		}
		public static void PenFiles(String name)
		{
			File file= new File(name+".txt");
			BufferedWriter	out=null;
		
		
			        try {
						file.createNewFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			        try {
							out= new BufferedWriter(new FileWriter(file));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
			
			BufferedReader br=null;
			try {
				br=new BufferedReader(new FileReader(yourFile));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String line="";
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(line!=null)
			{
			
				
					String []l=line.split(":");

				if(name.equals(l[0]))
				{
					try {
						out.write(l[1]);
						out.newLine();
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}

				

				try {
					line=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				br.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}
		public static String search(String pname)
		{
			String ret="";
			BufferedReader br=null;
			try {
				br=new BufferedReader(new FileReader(yourFile));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String line="";
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(line!=null)
			{
				if(line.contains(pname))
				{
					String []l=line.split(":");

					ret=ret+","+l[0];

				}

				try {
					line=br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ret;
		}

		public static String getDrives()
		{
			String dr="";
			File[] f = File.listRoots();

			for (int i = 0; i < f.length; i++) {

				String drive = f[i].getPath();

				dr=dr+", "+drive;



			}
			return dr;
		}
		public static File[] listf(String directoryName) {


			if(cls)
			{
				FileWriter fileWritter=null;
				try {
					fileWritter = new FileWriter(yourFile.getName(),true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				output = new BufferedWriter(fileWritter);
				cls=false;
			}
			// .............list file
			File directory = new File(directoryName);

			// get all the files from a directory
			File[] fList = directory.listFiles();

			if(fList!=null)
				for (File file : fList) {
					if (file.isFile()) {
						try {
							String s=file.getPath();
							String []ss=s.split(":");
							output.write(nm+":"+ss[1]);
							output.newLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(file.getPath());
					} else if (file.isDirectory()) {
						listf(file.getAbsolutePath());
					}
				}

			return fList;
		}             

	}
