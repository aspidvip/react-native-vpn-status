import * as React from 'react';

import { StyleSheet, View, Text, Alert } from 'react-native';
import { detectVPN } from 'react-native-vpn-status';

export default function App() {
  const [result, setResult] = React.useState<number | undefined>();

  const geee = async () => {
    const isStatus = await detectVPN();
    if(isStatus) {
      Alert.alert('Status', 'VPN is enabled!');
    }
  };
  React.useEffect(() => {
    geee();
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
