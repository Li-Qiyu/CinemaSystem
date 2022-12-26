package presentation.cn.ui;

import presentation.cloudgarden.resource.SWTResourceManager;
import presentation.cn.entity.Movie;
import presentation.cn.entity.TableManager;
import presentation.cn.ui.link;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ArmEvent;
import org.eclipse.swt.events.ArmListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;



public class SWTApp extends org.eclipse.swt.widgets.Composite {

	private Menu menu1;
	private TableColumn UserId;
	private TableColumn UserName;
	private TableColumn UserPwd;
	private TableColumn UserPhone;
	private TableColumn Sex;
	private Table table1;
	private Button btnDelete;
	private Button btnUpdate;
	private Button btnAdd;
	private TreeItem ͳ�Ʒ���;
	private TreeItem ���Ĺ���;
	private TreeItem ͼ�����;
	private TreeItem �û�����;
	private TreeItem ϵͳ����;
	private Tree tree1;
	private MenuItem exitMenuItem;
	private Menu fileMenu;
	private MenuItem fileMenuItem;
	private ArrayList<Movie> studentList = new ArrayList<Movie>();
	{
		SWTResourceManager.registerResourceUser(this);
	}

	public SWTApp(Composite parent, int style) {
		super(parent, style);
		initList();
		initGUI();
	}
	/**
	 * ��ʼ��ѧ�����ϣ���������󶨵������
	 * 2021-12-8
	 */
	void initList(){
		Movie stu = new Movie( "title", "running_time", "year", "�ֻ���","�Ա�");
		studentList.add(stu);
		Random random = new Random();
		for (int i = 1; i < 25; i++) {
			Movie student = new Movie("Harry Potter"+i, "10"+i+"min", "200"+i, "17600100251","��");
			studentList.add(student);
		}
	}

	org.eclipse.swt.graphics.Font GetFont(){
	 return	SWTResourceManager.getFont("Microsoft YaHei UI", 12, 0, false, false);
	}
	
	void ShowDialog(String txt){
		JOptionPane.showMessageDialog(new Panel(), txt, "��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
	}

	private void initGUI() {
		try {
			//���ô��ڴ�С
			this.setSize(1600, 1035);
			//���ñ�����ɫ
			this.setBackground(SWTResourceManager.getColor(214, 228, 216));
			FormLayout thisLayout = new FormLayout();
			this.setLayout(thisLayout);
			{
				
				//���û�������
				FormData table1LData = new FormData();
				table1LData.width = 1228;
				table1LData.height = 640;
				table1LData.left =  new FormAttachment(0, 1000, 341);
				table1LData.top =  new FormAttachment(0, 1000, 88);
				table1 = new Table(this, SWT.NONE);
				//������Ӧ
				TableManager.aotuColWidth(table1);
				//���б�ɫ
				TableManager.rowLight(table1);
				//��ʼ��������
				
				String[] titles = { "���",  "�ֻ���","�Ա�" };
				for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
				      TableColumn column = new TableColumn(table1, SWT.CENTER);
				      column.setText(titles[loopIndex]);
			    }
				
				//��ʼ�����ݣ���ǰ���List�������
				for (int loopIndex = 0; loopIndex < 8; loopIndex++) {
				      TableItem item = new TableItem(table1, SWT.CENTER);
				      item.setText(0,studentList.get(loopIndex).getUserId());
				      item.setText(1, studentList.get(loopIndex).getUserName());
				      item.setText(2, studentList.get(loopIndex).getUserPwd());
				      item.setText(3, studentList.get(loopIndex).getUserPhone());
				      item.setText(4, studentList.get(loopIndex).getSex());
				}
				
				for (int loopIndex = 0; loopIndex < titles.length; loopIndex++) {
					table1.getColumn(loopIndex).pack();
				    }

				table1.setBounds(25, 25, 220, 200);

			
				 
				table1.setFont(GetFont());
				
				table1.setLayoutData(table1LData);
		
				
				//������Դ
				//table1.setData(studentList);
			}
			{
				btnAdd = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.width = 165;
				button1LData.height = 61;
				button1LData.left =  new FormAttachment(0, 1000, 1050);
				button1LData.top =  new FormAttachment(0, 1000, 6);
				btnAdd.setLayoutData(button1LData);
				btnAdd.setText("add");
				btnAdd.setFont(GetFont());
			}
			{
				FormData tree1LData = new FormData();
				tree1LData.width = 289;
				tree1LData.height = 741;
				tree1LData.left =  new FormAttachment(0, 1000, -5);
				tree1LData.top =  new FormAttachment(0, 1000, 5);
				
				tree1 = new Tree(this, SWT.NONE);
				
				tree1.setLayoutData(tree1LData);
				//�������β˵�������
				tree1.setFont(GetFont());
				//�������β˵�
				tree1.setEnabled(true);
				//�Ƿ�������
				//tree1.setLinesVisible(true);
				//������ڵ㼰���ӽڵ�
				{
					ϵͳ���� = new TreeItem(tree1, SWT.NONE);
					ϵͳ����.setText("System Management");
					
					{
						�û����� = new TreeItem(ϵͳ����, SWT.NONE);
						�û�����.setText("User Management");
					}
					{
						ͼ����� = new TreeItem(ϵͳ����, SWT.NONE);
						ͼ�����.setText("Movie Managment");
					}
					{
						���Ĺ��� = new TreeItem(ϵͳ����, SWT.NONE);
						���Ĺ���.setText("Time Managment");
					}
					{
						ͳ�Ʒ��� = new TreeItem(ϵͳ����, SWT.NONE);
						ͳ�Ʒ���.setText("statistical analysis");
					}
					
				}
			}
			{
				btnUpdate = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button2LData = new FormData();
				button2LData.width = 165;
				button2LData.height = 61;
				button2LData.left =  new FormAttachment(0, 1000, 1236);
				button2LData.top =  new FormAttachment(0, 1000, 5);
				btnUpdate.setLayoutData(button2LData);
				btnUpdate.setText("Modify");
				btnUpdate.setFont(GetFont());
			}
			{
				btnDelete = new Button(this, SWT.PUSH | SWT.CENTER);
				FormData button3LData = new FormData();
				button3LData.width = 165;
				button3LData.height = 61;
				button3LData.left =  new FormAttachment(0, 1000, 1423);
				button3LData.top =  new FormAttachment(0, 1000, 5);
				btnDelete.setLayoutData(button3LData);
				btnDelete.setText("Delete");
				btnDelete.setFont(GetFont());
			}
			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
				{
					fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
					fileMenuItem.setText("Set UP");
					{
						fileMenu = new Menu(fileMenuItem);
						{
							exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
							exitMenuItem.setText("EXIT");
							exitMenuItem.addArmListener(new ArmListener() {
								
								@Override
								public void widgetArmed(ArmEvent arg0) {
								
									System.out.println("��ť�����....");
								}
							});
						}
						fileMenuItem.setMenu(fileMenu);
					}
				}
				
			}
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		SWTApp inst = new SWTApp(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
