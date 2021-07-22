package createdata;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateCustomerInformation {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Write customer data to file
		int min, max, bin, card_type, product_code;

		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập giá trị min : ");
		min = sc.nextInt();
		System.out.print("Nhập giá trị max : ");
		max = sc.nextInt();
		System.out.print("Nhập giá trị bin : ");
		bin = sc.nextInt();
		System.out.print("Nhập giá trị card_type : ");
		card_type = sc.nextInt();
		System.out.print("Nhập giá trị product_code : ");
		product_code = sc.nextInt();
		writeFile("customerFile.txt", dataInfor(min, max, bin, card_type, product_code).get(0));
		// Write batch data to file
		writeFile("batchIssuanceFile.txt", dataInfor(min, max, bin, card_type, product_code).get(1));
	}

	private static ArrayList<String> dataInfor(int min, int max, int bin, int card_type, int product_code) {
		ArrayList<String> arrayResult = new ArrayList<>();
		StringBuilder strCustomerInfor = new StringBuilder();
		StringBuilder strBatchIssuanceInfor = new StringBuilder();
		strCustomerInfor.append("{\n");
		strCustomerInfor.append("  \"batch_data\": [\n");
		strBatchIssuanceInfor.append("{\n");
		strBatchIssuanceInfor.append("  \"maker_name\": \"ECPay Gateway\",\n");
		strBatchIssuanceInfor.append("  \"branch_id\": \"999999\",\n");
		strBatchIssuanceInfor.append("  \"institution_id\": 1,\n");
		strBatchIssuanceInfor.append("  \"delta\": {\n");
		strBatchIssuanceInfor.append("    \"branchid\": \"999999\",\n");
		strBatchIssuanceInfor.append("    \"issue_date\": 1619667295,\n");
		strBatchIssuanceInfor.append("    \"bin\": \"" + bin + "\",\n");
		strBatchIssuanceInfor.append("    \"card_type\": \"" + card_type + "\",\n");
		strBatchIssuanceInfor.append("    \"product_code\": \"" + product_code + "\",\n");
		strBatchIssuanceInfor.append("    \"listInformation\": [\n");
		for (int i = min; i <= max; i++) {
			String range = String.format("%05d", i);
			strCustomerInfor.append("    {\n");
			strCustomerInfor.append("      \"cif\": \"75" + range + "\",\n");
			strCustomerInfor.append("      \"customer_name\": \"KHACH HANG ECPAY 75" + range + "\",\n");
			strCustomerInfor.append("      \"dob\": 318641278,\n");
			strCustomerInfor.append("      \"gender\": \"M\",\n");
			strCustomerInfor.append("      \"id_number\": \"75" + range + "\",\n");
			strCustomerInfor.append("      \"nationality\": \"VIET NAM\",\n");
			strCustomerInfor.append("      \"customer_type\": 1,\n");
			strCustomerInfor.append("      \"id_type\": 4,\n");
			strCustomerInfor.append("      \"cif_status\": 50,\n");
			strCustomerInfor.append("      \"phone1\": \"0817755036\",\n");
			strCustomerInfor.append("      \"listAccounts\": [\n");
			strCustomerInfor.append("       {\n");
			strCustomerInfor.append("          \"account_number\": \"1610175" + range + "\",\n");
			strCustomerInfor.append("          \"account_type\": 20,\n");
			strCustomerInfor.append("          \"currency_code\": 704,\n");
			strCustomerInfor.append("          \"acc_status\": 50\n");
			strCustomerInfor.append("       },\n");
			strCustomerInfor.append("       {\n");
			strCustomerInfor.append("          \"account_number\": \"1600175" + range + "\",\n");
			strCustomerInfor.append("          \"account_type\": 20,\n");
			strCustomerInfor.append("          \"currency_code\": 704,\n");
			strCustomerInfor.append("          \"acc_status\": 50\n");
			strCustomerInfor.append("       }\n");
			strCustomerInfor.append("      ]\n");

			if (i == max) {
				strCustomerInfor.append("    }\n");
				strBatchIssuanceInfor.append(batchIssuanceInfor(false, range));
			} else {
				strCustomerInfor.append("    },\n");
				strBatchIssuanceInfor.append(batchIssuanceInfor(true, range));
			}
		}
		strCustomerInfor.append("  ]\n");
		strCustomerInfor.append("}");
		strBatchIssuanceInfor.append("    ]\n");
		strBatchIssuanceInfor.append("  }\n");
		strBatchIssuanceInfor.append("}\n");
		arrayResult.add(strCustomerInfor.toString());
		arrayResult.add(strBatchIssuanceInfor.toString());
		return arrayResult;
	}

	private static String batchIssuanceInfor(boolean isComma, String range) {
		StringBuilder strBatchIssuanceInfor = new StringBuilder();
		strBatchIssuanceInfor.append("      {\n");
		strBatchIssuanceInfor.append("        \"cardIndicator\": \"P\",\n");
		strBatchIssuanceInfor.append("        \"cif\": \"75" + range + "\",\n");
		strBatchIssuanceInfor.append("        \"embossname\": \"KHACH HANG ECPAY 75" + range + "\",\n");
		strBatchIssuanceInfor.append("        \"ovsFlag\": 0,\n");
		strBatchIssuanceInfor.append("        \"priAccNo\": \"1610175" + range + "\"\n");
		strBatchIssuanceInfor.append("      },\n");
		strBatchIssuanceInfor.append("      {\n");
		strBatchIssuanceInfor.append("        \"cardIndicator\": \"P\",\n");
		strBatchIssuanceInfor.append("        \"cif\": \"75" + range + "\",\n");
		strBatchIssuanceInfor.append("        \"embossname\": \"KHACH HANG ECPAY 75" + range + "\",\n");
		strBatchIssuanceInfor.append("        \"ovsFlag\": 0,\n");
		strBatchIssuanceInfor.append("        \"priAccNo\": \"1600175" + range + "\"\n");

		if (!isComma) {
			strBatchIssuanceInfor.append("      }\n");
		} else {
			strBatchIssuanceInfor.append("      },\n");
		}
		return strBatchIssuanceInfor.toString();
	}

	private static void writeFile(String fileName, String data) {
		try {
			FileWriter myWriter = new FileWriter(fileName);
			myWriter.write(data);
			myWriter.close();
			System.out.println("Successfully wrote to the " + fileName + ".");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
