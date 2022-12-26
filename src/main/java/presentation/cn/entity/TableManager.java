package presentation.cn.entity;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Table;

import java.text.Collator;
import java.util.Locale;

public class TableManager {

	/**
	 * 为表列添加排序功能
	 * 
	 * @param table
	 *            表格
	 * @param column
	 *            表列
	 */
	public static void addSorter(final Table table, final TableColumn column) {
		column.addListener(SWT.Selection, new Listener() {
			boolean isAscend = true;
			Collator comparator = Collator.getInstance(Locale.getDefault());

			public void handleEvent(Event e) {
				int columnIndex = getColumnIndex(table, column);
				TableItem[] items = table.getItems();

				for (int i = 1; i < items.length; i++) {
					String value2 = items[i].getText(columnIndex);
					for (int j = 0; j < i; j++) {
						String value1 = items[j].getText(columnIndex);
						boolean isLessThan = comparator.compare(value2, value1) < 0;
						if ((isAscend && isLessThan)
								|| (!isAscend && !isLessThan)) {
							String[] values = getTableItemText(table, items[i]);
							Image image = items[i].getImage();
							Object obj = items[i].getData();
							boolean chck = items[i].getChecked();
							items[i].dispose();

							TableItem item = new TableItem(table, SWT.NONE, j);
							item.setChecked(chck);
							item.setImage(image);
							item.setText(values);
							item.setData(obj);
							items = table.getItems();
							break;
						}
					}
				}

				table.setSortColumn(column);
				table.setSortDirection((isAscend ? SWT.UP : SWT.DOWN));
				isAscend = !isAscend;
			}
		});
	}

	private static int getColumnIndex(Table table, TableColumn column) {
		TableColumn[] columns = table.getColumns();
		for (int i = 0; i < columns.length; i++) {
			if (columns[i].equals(column))
				return i;
		}
		return -1;
	}

	private static String[] getTableItemText(Table table, TableItem item) {
		int count = table.getColumnCount();
		String[] strs = new String[count];
		for (int i = 0; i < count; i++) {
			strs[i] = item.getText(i);
		}
		return strs;
	}

	/**
	 * 列适应表格宽度 第一列固定其他列计算公式:新列的宽度= ( 新表格宽度 - 就表格宽度 ) / 列数 + 旧列的宽度
	 * 
	 * @param table
	 *            表格
	 */
	public static void aotuColWidth(final Table table) {
		table.addControlListener(new ControlAdapter() {
			public void controlResized(final ControlEvent e) {
				int oldTableWidth = 0;
				for (int i = 0; i < table.getColumnCount(); i++) {
					oldTableWidth += table.getColumn(i).getWidth();
				}
				for (int i = 0; i < table.getColumnCount(); i++) {
					int oldWidth = table.getColumn(i).getWidth();
					table
							.getColumn(i)
							.setWidth(
									(table.getSize().x
											- table.getColumn(0).getWidth() - oldTableWidth)
											/ (table.getColumnCount() - 1)
											+ oldWidth);
				}
			}
		});

	}

	/**
	 * 添加光棒以及各行颜色差效果
	 * 
	 * @param table
	 *            table
	 */
	public static void rowLight(final Table table) {
		table.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				TableItem item = table.getItem(new Point(e.x, e.y));
				if (item != null) {
					for (int i = 0; i < table.getItemCount(); i++) {
						if (i % 2 == 0) {
							table.getItem(i).setBackground(
									Display.getCurrent().getSystemColor(
											SWT.COLOR_WHITE));
						} else {
							table.getItem(i).setBackground(
									Display.getCurrent().getSystemColor(
											SWT.COLOR_WIDGET_LIGHT_SHADOW));
						}
					}
					table.indexOf(item);
					item.setBackground(Display.getCurrent().getSystemColor(
							SWT.COLOR_YELLOW));
				}
			}
		});
	}
}
