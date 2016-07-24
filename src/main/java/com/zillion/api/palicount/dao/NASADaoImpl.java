package com.zillion.api.palicount.dao;

import javax.ws.rs.WebApplicationException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import com.zillion.api.palicount.model.NASAResultsWrapper;

public class NASADaoImpl implements NASADao {

	private final String NASA_OPENAPI_URL = "https://api.nasa.gov/patents/content?query=";

	private String builRequestURL(String search, int count) {
		String URL = NASA_OPENAPI_URL + search + "&limit=" + count
				+ "&api_key=DEMO_KEY";
		return URL;
	}

	/* (non-Javadoc)
	 * @see com.zillion.api.palicount.dao.NASADao#getResource(java.lang.String, int)
	 * Gets the data from the NASA API
	 */
	@Override
	public NASAResultsWrapper getResource(String search, int count) {

		String requestURL = builRequestURL(search, count);
		System.out.println(requestURL);
		JAXBElement<NASAResultsWrapper> wrapper = null;
		try {

			JAXBContext jaxbContext = JAXBContext
					.newInstance(NASAResultsWrapper.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			unmarshaller.setProperty(MarshallerProperties.MEDIA_TYPE,
					"application/json");
			unmarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT,
					false);

			StreamSource source = new StreamSource(requestURL);

			wrapper = unmarshaller.unmarshal(source, NASAResultsWrapper.class);

		} catch (JAXBException e) {
			e.printStackTrace();
			throw new WebApplicationException(e.getErrorCode());
		}

		return wrapper.getValue();
	}
}
