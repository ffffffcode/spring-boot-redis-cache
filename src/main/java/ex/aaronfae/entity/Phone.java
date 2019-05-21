package ex.aaronfae.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NonNull;

@Data
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	public Integer id;
	@NonNull
	private String name;

}
