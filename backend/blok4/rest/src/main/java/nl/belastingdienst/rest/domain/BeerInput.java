package nl.belastingdienst.rest.domain;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public record BeerInput(String name) {
}