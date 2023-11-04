package wl.open_house_api.modules.role.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wl.open_house_api.infra.exeptions.ValidacaoException;
import wl.open_house_api.modules.role.model.entity.Role;
import wl.open_house_api.modules.role.model.mapper.RoleMapper;
import wl.open_house_api.modules.role.model.request.RoleRequest;
import wl.open_house_api.modules.role.model.request.RoleRequestCreat;
import wl.open_house_api.modules.role.model.response.RoleResponse;
import wl.open_house_api.modules.role.repository.RoleRepository;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {

    final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public RoleResponse insert(RoleRequestCreat roleRequestCreat) {
        Role role = repository.save(RoleMapper.INSTANCE.roleRequestCreatToRole(roleRequestCreat));
        return RoleMapper.INSTANCE.roleToRoleResponse(role);
    }

    @Override
    @Transactional
    public RoleResponse update(RoleRequest roleRequest) {
        verificarRole(roleRequest.id());
        Role role = repository.save(RoleMapper.INSTANCE.roleRequestToRole(roleRequest));
        return RoleMapper.INSTANCE.roleToRoleResponse(role);
    }

    @Override
    @Transactional
    public RoleResponse findRole(Long id) {
        Role role = repository.getReferenceById(id);
        return RoleMapper.INSTANCE.roleToRoleResponse(role);
    }

    @Override
    public Page<RoleResponse> findRoles(Pageable pageable) {
        return repository.findAll(pageable).map(RoleMapper.INSTANCE::roleToRoleResponse);
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        repository.delete(verificarRole(id));
    }


    public Role verificarRole(Long id){
        Optional<Role> role = repository.findById(id);
        if(role.isEmpty()){
            throw new ValidacaoException("A Role não existe, verifique e tente e novamente!");
        }
        return role.get();
    }
}
