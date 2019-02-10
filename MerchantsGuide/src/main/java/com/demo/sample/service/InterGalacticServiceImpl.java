package com.demo.sample.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.demo.sample.util.InterGalacticConverter;
import com.demo.sample.util.InterGalacticUnits;
import com.demo.sample.util.MetalNames;
import com.demo.sample.util.MetalPrice;

@Service("interGalacticService")
public class InterGalacticServiceImpl implements InterGalacticService {

	private static final Logger LOGGER = Logger.getLogger(InterGalacticServiceImpl.class.getName());
	private static final String DEFAULT_MSG = "I have no idea what you are talking about";

	@Autowired
	private InterGalacticConverter interGalacticConverter;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.demo.sample.service.InterGalacticService#queryMetalsAndDirts(java.lang.
	 * String)
	 */
	@Override
	public String queryMetalsAndDirts(String query) {
		LOGGER.log(Level.INFO, "Querying: {}", query);
		String response = null;
		try {
			response = processService(query);
			return response;
		} catch (Exception e) {
			LOGGER.log(Level.WARNING, "Fault occured");
			return DEFAULT_MSG;
		}
	}

	private String processService(String query) {
		String igStr = findInterGalacticUnitString(query);
		String metalName = findMetalName(query);
		if (StringUtils.isEmpty(metalName) && !StringUtils.isEmpty(igStr)) {
			int value = convertInterGalacticToDecimal(query);
			return buildResponse(igStr, value);
		} else if (!StringUtils.isEmpty(metalName) && !StringUtils.isEmpty(igStr)) {
			int totalPrice = findTotalPrice(query, metalName);
			return buildResponse(metalName, igStr, totalPrice);
		} else {
			return DEFAULT_MSG;
		}
	}

	private String buildResponse(String metalName, String igStr, int totalPrice) {
		return igStr + metalName + " is " + totalPrice + " Credits";
	}

	private String buildResponse(String igStr, int value) {
		return igStr + "is " + value;
	}

	private int convertInterGalacticToDecimal(String query) {
		String romanNumberStr = findRomanNumberString(query);
		int value = this.interGalacticConverter.romanToDecimal(romanNumberStr);
		return value;
	}

	private int findTotalPrice(String query, String metalName) {
		String romanNumberStr = findRomanNumberString(query);
		int price = findPriceofMetal(metalName);
		int units = this.interGalacticConverter.romanToDecimal(romanNumberStr);

		int totalCosts = price * units;

		return totalCosts;
	}

	private int findPriceofMetal(String metalName) {
		if (metalName.toUpperCase().contains(MetalNames.SILVER.getValue())) {
			return MetalPrice.SILVER.getValue();
		} else if (metalName.toUpperCase().contains(MetalNames.GOLD.getValue())) {
			return MetalPrice.GOLD.getValue();
		} else if (metalName.toUpperCase().contains(MetalNames.IRON.getValue())) {
			return MetalPrice.IRON.getValue();
		}
		return 0;
	}

	private String findRomanNumberString(String query) {
		String romanNumberStr = "";
		String[] strArray = query.split(" ");

		for (String str : strArray) {
			if (str.equalsIgnoreCase(InterGalacticUnits.GLOB.toString())) {
				romanNumberStr += InterGalacticUnits.GLOB.getValue();
			} else if (str.equalsIgnoreCase(InterGalacticUnits.PISH.toString())) {
				romanNumberStr += InterGalacticUnits.PISH.getValue();
			} else if (str.equalsIgnoreCase(InterGalacticUnits.PROK.toString())) {
				romanNumberStr += InterGalacticUnits.PROK.getValue();
			} else if (str.equalsIgnoreCase(InterGalacticUnits.TEGJ.toString())) {
				romanNumberStr += InterGalacticUnits.TEGJ.getValue();
			}
		}
		return romanNumberStr;
	}

	private String findInterGalacticUnitString(String query) {
		String igStr = "";
		String[] strArray = query.split(" ");

		for (String str : strArray) {
			if (str.equalsIgnoreCase(InterGalacticUnits.GLOB.toString())) {
				igStr = igStr + str + " ";
			} else if (str.equalsIgnoreCase(InterGalacticUnits.PISH.toString())) {
				igStr = igStr + str + " ";
			} else if (str.equalsIgnoreCase(InterGalacticUnits.PROK.toString())) {
				igStr = igStr + str + " ";
			} else if (str.equalsIgnoreCase(InterGalacticUnits.TEGJ.toString())) {
				igStr = igStr + str + " ";
			}
		}
		return igStr;
	}

	private String findMetalName(String query) {
		if (StringUtils.isEmpty(query)) {
			return null;
		}

		if (query.toUpperCase().contains(MetalNames.SILVER.getValue())) {
			return MetalNames.SILVER.getValue();
		} else if (query.toUpperCase().contains(MetalNames.GOLD.getValue())) {
			return MetalNames.GOLD.getValue();
		} else if (query.toUpperCase().contains(MetalNames.IRON.getValue())) {
			return MetalNames.IRON.getValue();
		}

		return null;
	}

	public void setInterGalacticConverter(InterGalacticConverter interGalacticConverter) {
		this.interGalacticConverter = interGalacticConverter;
	}
}
