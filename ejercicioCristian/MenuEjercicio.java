package ejercicioCristian;

import javax.swing.JOptionPane;

public class MenuEjercicio {

	public static void main(String[] args) {
		
		int codMenuPpal = 0, codMenuTipico = 0, codMenuCarta =0, codMenuInternacional =0;
		
		do {
			String menu = "MENU RESTAURANTE\n\n";
			menu+= "1.Plato típico\n";
			menu+= "2.Plato a la carta\n";
			menu+= "3.Plato internacional\n";
			menu+= "4.Salir\n\n";
			menu+= "Por favor seleccione una opción\n";
			codMenuPpal= Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (codMenuPpal) {
			
			case 1:
				do {
					String menuTipico = "MENU TIPICO \n\n";
					menuTipico+= "1.Frijoles\n";
					menuTipico+= "2.Sopa de verduras\n";
					menuTipico+= "3.Regresar\n";
					menuTipico+= "Por favor seleccione una opción\n";
					codMenuTipico= Integer.parseInt(JOptionPane.showInputDialog(menuTipico));
					
					switch (codMenuTipico) {
					case 1:
						JOptionPane.showMessageDialog(null, "Se ha solicitado un plato de frijoles, el costo es de $" + 12000);
						break;					
					case 2:
						JOptionPane.showMessageDialog(null, "Se ha solicitado una sopa de verduras, el costo es de $" + 8000);
						break;					
					case 3:
						break;
					default:{
						JOptionPane.showMessageDialog(null, "no corresponde a un" + "código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
						codMenuTipico = 1;}
						break;
						}
					if (codMenuTipico ==1 || codMenuTipico == 2) {codMenuTipico= Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea repetir el menú tipico, de los contrario regresará al menú principal"));}
					if (codMenuTipico!=1) {
						codMenuTipico=3;
					}
					else { codMenuTipico = 0;}
					
					}

				while (codMenuTipico !=3);
				break;
				
			case 2:
				do {
					String menuCarta = "MENU A LA CARTA \n\n";
					menu+= "1.Pollo con champiñones\n";
					menu+= "2.Spaguetti con albondigas\n";
					menu+= "3.Regresar\n";
					menu+= "Por favor seleccione una opción\n";
					codMenuCarta= Integer.parseInt(JOptionPane.showInputDialog(menuCarta));
					
					switch (codMenuCarta) {
					case 1:
						JOptionPane.showMessageDialog(null, "Se ha solicitado un plato de pollo con champiñones, el costo es de $" + 18000);
						break;					
					case 2:
						JOptionPane.showMessageDialog(null, "Se ha solicitado spaguetti con albondigas, el costo es de $" + 160000);
						break;					
					case 3:
						break;
					default:
						JOptionPane.showMessageDialog(null, "no corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
						break;
						}
					codMenuCarta= Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea repetir el menú a la carta, de los contrario regresará al menú principal"));
					
					if (codMenuCarta!=1) {
						codMenuCarta=3;
					}
					else { codMenuCarta = 0;}
				}
				
				while (codMenuCarta !=3);
				break;
				
					
			case 3:
				do {
					String menuInternacional = "MENU INTERNACIONAL \n\n";
					menu+= "1.Sushi\n";
					menu+= "2.Arroz con pollo\n";
					menu+= "3.Regresar\n";
					menu+= "Por favor seleccione una opción\n";
					codMenuInternacional= Integer.parseInt(JOptionPane.showInputDialog(menuInternacional));
					
					switch (codMenuInternacional) {
					case 1:
						JOptionPane.showMessageDialog(null, "Se ha solicitado un plato de sushi, el costo es de $" + 22000);
						break;					
					case 2:
						JOptionPane.showMessageDialog(null, "Se ha solicitado un plato de arroz con pollo, el costo es de $" + 15000);
						break;					
					case 3:
						break;
					default:
						JOptionPane.showMessageDialog(null, "no corresponde a un código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
						break;
						}
					
					codMenuInternacional= Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1 si desea repetir el menú internacional, de los contrario regresará al menú principal"));
					if (codMenuInternacional!=1) {
						codMenuInternacional=3;
					}
					
					else { codMenuInternacional = 0;}
					
					}
				while (codMenuInternacional !=3);
				break;
				
				
			case 4:
				codMenuPpal = 4;
				break;
				
				
			default:
				JOptionPane.showMessageDialog(null, "no corresponde a un" + "código válido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
				break;
			}
			
		} while (codMenuPpal!=4);

	}

}
