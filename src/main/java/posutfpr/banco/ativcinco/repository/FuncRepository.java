package posutfpr.banco.ativcinco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import posutfpr.banco.ativcinco.entity.FuncEntity;

public interface FuncRepository extends JpaRepository<FuncEntity, Long> {
	
	
	FuncEntity findByNameAndDependents(String name, Integer dependents);
	
	 
	List<FuncEntity> findByDepartName(String name);
	
	
	FuncEntity findTopByOrderByPayDesc();
	
	
	List<FuncEntity> findFirst3ByOrderByPayDesc();
	
	
	@Query("select f from FuncEntity f where dependents = 0 order by name asc")
	List<FuncEntity>findByFuncNoDependents();
	
    @Query(" select f from FuncEntity f  where pay >= ?1 order by name asc") 
    List<FuncEntity> findByPayBigger(Long pay);
    
    @Query(value = "select * from funcionario where salario > ?1", nativeQuery = true)
    List<FuncEntity> findByPay(Long pay);
    
    
    @Query(name = "FuncEntity.byDependents")
    List<FuncEntity> findByDepNamedQuery(Integer qtdDepend);
    
    @Query(name = "FuncEntity.byPartOfName")
    List<FuncEntity> findByPartOfNameNativeQuery(String nome);
    
       

}