import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class AcademyInfo {

	public static void main(String[] args) {
		final boolean sql=true;
		String url = "http://openapi.academyinfo.go.kr/openapi/service/rest/BasicInformationService/getNoticeUniversitySearchList?serviceKey=yQgK2fUWSok7FB68VEHlbaGfw5j8p6ibF2oL0bSQuCHAnRX4FKNt8STGJv6cE8c%2F7YqJo%2B8dtkL%2Fc8B1BMnwgw%3D%3D&svyYr=2020&schlId=&schlKrnNm=&clgcpDivCd=&schlDivCd=&schlKndCd=&znCd=&estbDivCd=&numOfRows=999&pageNo=&";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet req = new HttpGet(url);

		try {

			//			����� �����͸� out������ �����ϱ� ����

			File file;
			if (sql) {
				file= new File("sql/academy_list.sql");
			}
			else
				file= new File("out/academy_list.txt");
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			//			����� �����͸� out������ �����ϱ� ��

			HttpResponse res = client.execute(req);

			if(res.getStatusLine().getStatusCode() == 200) {
				String body = EntityUtils.toString(res.getEntity(),"UTF-8");

				System.out.println(body);

				ObjectMapper mapper = new XmlMapper();

				AcademyResponse result = mapper.readValue(body, AcademyResponse.class);

				System.out.println(result.getHeader().getResultCode());
				System.out.println(result.getHeader().getResultMsg());


				for (item item : result.getBody().getItems()) {
					System.out.println(item.getSchlKrnNm());
					System.out.println(item);


					if (sql) {
						writer.write(item.toSQL());

					}					
					else
						writer.write(item.toString());
					//					out������ �����ϱ� ��ºκ� ����
					writer.newLine();
				}

				writer.close();
				//				out������ �����ϱ� ��ºκ� ��
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
