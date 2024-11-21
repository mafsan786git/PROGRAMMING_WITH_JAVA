import java.util.*;

class GraphEquations {
    
}

class GraphEquationsSolution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // return usingWeightedGraph(equations,values,queries);
        return usingWeightedUnionFind(equations,values,queries);
    }
    
    
    private double[] usingWeightedUnionFind(List<List<String>> equations, double[] values, List<List<String>> queries){
        GraphEquationsUnionFind uf = new GraphEquationsUnionFind();
        for(int index = 0;index< equations.size(); index++){
            List<String> variables = equations.get(index);
            String dividend = variables.get(0), divisor = variables.get(1);
            double quotient = values[index];
            
            uf.union(dividend,divisor,quotient);
        }
        
        double[] results = new double[queries.size()];
        
        for(int index=0; index<queries.size(); index++){
            List<String> variables = queries.get(index);
            String dividend = variables.get(0), divisor = variables.get(1);
            
            if(!uf.graphMap().containsKey(dividend) || !uf.graphMap().containsKey(divisor)){
                results[index] = -1.0;
                continue;
            }
            AbstractMap.SimpleEntry<String,Double> dividendRootDetails = uf.find(dividend);
            AbstractMap.SimpleEntry<String,Double> divisorRootDetails = uf.find(divisor);
            
            String dividendRoot = dividendRootDetails.getKey();
            String divisorRoot = divisorRootDetails.getKey();
            Double dividendValue = dividendRootDetails.getValue();
            Double divisorValue = divisorRootDetails.getValue();
            
            if(!dividendRoot.equals(divisorRoot)){
                results[index] = -1.0;
            }else{
                results[index] = dividendValue/divisorValue;
            }
        }
        return results;  
        
    }
    
    private double[] usingWeightedGraph(List<List<String>> equations, double[] values, List<List<String>> queries){
        
        //build graph
        Map<String,Map<String,Double>> graph = new HashMap<>();
        
        for(int index = 0;index< equations.size(); index++){
            List<String> variables = equations.get(index);
            String dividend = variables.get(0), divisor = variables.get(1);
            
            graph.putIfAbsent(dividend,new HashMap<>());
            graph.putIfAbsent(divisor,new HashMap<>());
            
            double quotient = values[index];
            graph.get(dividend).put(divisor,quotient);
            graph.get(divisor).put(dividend,1/quotient);
        }
        
        //run queries
        //conditions 1 : dividend and divisor should be in graph else return -1;
        //else back track
        double[] results = new double[queries.size()];
        
        for(int index=0; index<queries.size(); index++){
            List<String> variables = queries.get(index);
            String dividend = variables.get(0), divisor = variables.get(1);
            
            if(!graph.containsKey(dividend) || !graph.containsKey(divisor)){
                results[index] = -1.0;
                continue;
            }
            
            if(dividend == divisor){
                results[index] = 1.0;
                continue;
            }
            Set<String> visited = new HashSet<>();
            results[index] = dfsBacktrack(graph,dividend,divisor,1.0,visited); 
        }
        return results;
    }
    
    private double dfsBacktrack(Map<String,Map<String,Double>> graph, String currNode,String targetNode,double accProduct,Set<String> visited){
        
        visited.add(currNode);
        double result = -1.0;
        
        Map<String,Double> neighbours = graph.get(currNode);
        if(neighbours.containsKey(targetNode)){
            result = accProduct * neighbours.get(targetNode);
        }else{
            
            for(Map.Entry<String,Double> pairs : neighbours.entrySet()){
                if(visited.contains(pairs.getKey())){
                    continue;
                }
                result = dfsBacktrack(graph,pairs.getKey(),targetNode,accProduct*pairs.getValue(),visited);
                if(result != -1.0)
                    break;
            }
        }
        
        visited.remove(currNode);
        return result;
    }
}

class GraphEquationsUnionFind{
    private HashMap<String,AbstractMap.SimpleEntry<String,Double>> graph = new HashMap<>();
    
    
    public AbstractMap.SimpleEntry<String,Double> find(String rootId){
        if(!graph.containsKey(rootId)){
            graph.put(rootId,new AbstractMap.SimpleEntry<>(rootId,1.0));
        }
        
        AbstractMap.SimpleEntry<String,Double> rootDetails = graph.get(rootId);
        if(!rootDetails.getKey().equals(rootId)){
            AbstractMap.SimpleEntry<String,Double> newRootDetails =  find(rootDetails.getKey());
            graph.put(rootId,new AbstractMap.SimpleEntry<>(
                newRootDetails.getKey(),newRootDetails.getValue() * rootDetails.getValue()
            ));
        }
        return graph.get(rootId);
    }
    
    public void union(String dividend,String divisor,Double value){
        
        AbstractMap.SimpleEntry<String,Double> dividendGroupDetails = find(dividend);
        AbstractMap.SimpleEntry<String,Double> divisorGroupDetails  = find(divisor);
        
        if(dividendGroupDetails.getKey() != divisorGroupDetails.getKey()){
            graph.put(dividendGroupDetails.getKey(), 
                      new AbstractMap.SimpleEntry<>(
                          divisorGroupDetails.getKey(),
                          divisorGroupDetails.getValue() * value/dividendGroupDetails.getValue()
                      ));
        }
    }
    
    public HashMap<String,AbstractMap.SimpleEntry<String,Double>> graphMap(){
        return this.graph;
    }
           
}