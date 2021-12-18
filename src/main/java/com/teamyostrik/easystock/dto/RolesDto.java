package com.teamyostrik.easystock.dto;
import com.teamyostrik.easystock.models.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {
	private Integer id;
	private String roleName;
	private UtilisateurDto utilisateur;

	public static RolesDto fromEntity(Roles roles)
	{
		if(roles == null)
		{
			return null;
		}


		return RolesDto.builder()
				.id(roles.getId())
				.roleName(roles.getRoleName())
				.build();
	}

	public static Roles toEntity(RolesDto rolesDto)
	{
		if(rolesDto == null)
		{
			return null;
		}
		Roles roles = new Roles();
		roles.setRoleName(rolesDto.getRoleName());
		return roles;
	}
}
