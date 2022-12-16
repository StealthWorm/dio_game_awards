import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import { MaterialCommunityIcons } from '@expo/vector-icons';

import { Vote } from "../screens/Vote";
import { Winner } from "../screens/Winner";

const { Navigator, Screen } = createBottomTabNavigator();

export function StackRoutes() {
  return (
    <Navigator screenOptions={({ route }) => ({
      headerShown: false,
      tabBarStyle: {
        height: 70,
        paddingHorizontal: 2,
        paddingTop: 0,
        backgroundColor: 'rgba(34,36,40,1)',
        position: 'absolute',
        borderTopWidth: 0,
      },
    })}
    >
      <Screen
        name="votes"
        component={Vote}
        options={{
          tabBarLabel: 'Votar',
          tabBarActiveTintColor: 'white',
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons
              name="home"
              color="#6dff60"
              size={size}
            />
          )
        }}
      />

      <Screen
        name="winner"
        component={Winner}
        options={{
          tabBarLabel: 'Result',
          tabBarActiveTintColor: 'white',
          tabBarIcon: ({ color, size }) => (
            <MaterialCommunityIcons
              name="trophy"
              color="#6dff60"
              size={size}
            />
          )
        }}
      />
    </Navigator>
  );
}